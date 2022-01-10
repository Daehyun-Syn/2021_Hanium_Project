# --coding: utf-8 --

import numpy as np
import tensorflow as tf
from tensorflow import keras
from flask import Flask, request
from util import CmmUtil as cu
application = Flask(__name__)


@application.route("/")
def hello():
    return "<h1>안녕</h1>"


@application.route("/image")
def main():

    img_height = 180  # 이미지 높이 크기
    img_width = 180  # 이미지 넓이 크기

    image_path = cu.CmmUtil.nvl(request.args.get("ipath"))
    print(image_path)

    # 이미지 전처리
    img = keras.preprocessing.image.load_img(
        image_path, target_size=(img_height, img_width)
    )

    # 이미지 파일의 값을 배열로 변경
    img_array = keras.preprocessing.image.img_to_array(img)

    # tf.keras 모델은 한 번에 샘플의 묶음 또는 배치(batch)로 예측을 만드는데 최적화되어 있음
    # 무조건 한개의 파일을 분석하는 경우도 강제로 2차원 배열로 만들어야 함
    img_array = tf.expand_dims(img_array, 0)  # Create a batch

    # 학습모델 로딩하기
    loaded_model = tf.keras.models.load_model("model/myFood.h5")

    # 이미지 예측하기
    predictions = loaded_model.predict(img_array)

    # 정확도 분석하기
    score = tf.nn.softmax(predictions[0])

    score = tf.nn.softmax(predictions[0])
    class_names=['Baechukimchi', 'bulgogi', 'Dotorimuk', 'Gimbap', 'Godeungeogui', 'Gosarinamul',
                 'Gyelangug', 'Gyeranmari', 'Hobakjuk', 'Hongeohoemuchim', 'Hunjeori', 'Janchiguksu',
                 'Jangjorim', 'Kimchijjigae', 'Makguksu', 'Miyeokguk', 'Nurungji', 'Samgyetang', 'Songpyeon',
                 'Sujeonggwa', 'Sukjunamul', 'Ttangkongjorim', 'Yakgwa', 'Yubuchobab', 'Yukgaejang', 'Zhajiangmian']
    res = class_names[np.argmax(score)]
    return res


if __name__ == "__main__":
    application.run(host="127.0.0.1")