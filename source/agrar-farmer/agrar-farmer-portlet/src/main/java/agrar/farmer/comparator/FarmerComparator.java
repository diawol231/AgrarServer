package agrar.farmer.comparator;

import agrar.farmer.sbuilder.model.Farmer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FarmerComparator {
	
	public static List<Farmer> sortFarmer(List<Farmer> farmerList, String orderByCol, String orderByType) {

		// Сортировка по имени
		if (orderByCol.equals("name")) {
			if (orderByType.equals("asc")) {
				Collections.sort(farmerList, FarmerComparator.nameAsc);
			} else {
				Collections.sort(farmerList, FarmerComparator.nameDesc);
			}
		}
		
		return farmerList;
	}

	/**
	 * Метод сравнения фермеров по названию по возрастанию
	 */
	public static Comparator<Farmer> nameAsc = new Comparator<Farmer>() {
		@Override
		public int compare(Farmer o1, Farmer o2) {
			Farmer farmer1 = (Farmer) o1;
			Farmer farmer2 = (Farmer) o2;
			int value = farmer1.getName().toLowerCase().compareTo(farmer2.getName().toLowerCase());
			
			return value;
		}
	};

	/**
	 * Метод сравнения фермеров по названию по убыванию
	 */
	public static Comparator<Farmer> nameDesc = new Comparator<Farmer>() {
		@Override
		public int compare(Farmer o1, Farmer o2) {
			Farmer farmer1 = (Farmer) o1;
			Farmer farmer2 = (Farmer) o2;
			int value = farmer2.getName().toLowerCase().compareTo(farmer1.getName().toLowerCase());
			
			return value;
		}
	};

}
