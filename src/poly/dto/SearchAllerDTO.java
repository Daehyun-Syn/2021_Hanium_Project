package poly.dto;

import java.util.Arrays;
import java.util.List;

public class SearchAllerDTO {

	private String food_name;
	private String food_material;
	private String food_allergy; 
	private String food_kcal;
	private String alert;
	private List<String> food_material1;
	private List<String> food_allergy1;
	
	
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_allergy() {
		return food_allergy;
	}
	public void setFood_allergy(String food_allergy) {
		this.food_allergy = food_allergy;
	}
	public String getFood_kcal() {
		return food_kcal;
	}
	public void setFood_kcal(String food_kcal) {
		this.food_kcal = food_kcal;
	}
	
	public String getFood_material() {
		return food_material;
	}
	public void setFood_material(String food_material) {
		this.food_material = food_material;
	}
	public List<String> getfood_material1() {
		return food_material1;
	}

	public void setfood_material1(String food_material1) {
		this.food_material1 = Arrays.asList(food_material1.split(","));
	}
	public List<String> getfood_allergy1() {
		return food_allergy1;
	}
	
	public void setfood_allergy1(String food_allergy1) {
		this.food_allergy1 = Arrays.asList(food_allergy1.split(","));
	}

	
}
