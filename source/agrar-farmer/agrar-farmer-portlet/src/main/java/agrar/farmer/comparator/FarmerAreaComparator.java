package agrar.farmer.comparator;

import agrar.farmer.sbuilder.model.FarmerArea;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FarmerAreaComparator {

	public static List<FarmerArea> sortFarmerArea(List<FarmerArea> farmerAreaList, String orderByCol, String orderByType) {

		// Сортировка по имени
		if (orderByCol.equals("name")) {
			if (orderByType.equals("asc")) {
				Collections.sort(farmerAreaList, FarmerAreaComparator.nameAsc);
			} else {
				Collections.sort(farmerAreaList, FarmerAreaComparator.nameDesc);
			}
		}
		// Сортировка по коду
		else if (orderByCol.equals("code")) {
			if (orderByType.equals("asc")) {
				Collections.sort(farmerAreaList, FarmerAreaComparator.codeAsc);
			} else {
				Collections.sort(farmerAreaList, FarmerAreaComparator.codeDesc);
			}
		}

		return farmerAreaList;
	}

	/**
	 * Метод сравнения районов фермера по названию по возрастанию
	 */
	public static Comparator<FarmerArea> nameAsc = new Comparator<FarmerArea>() {
		@Override
		public int compare(FarmerArea o1, FarmerArea o2) {
			FarmerArea farmArea1 = (FarmerArea) o1;
			FarmerArea farmArea2 = (FarmerArea) o2;
			int value = farmArea1.showArea().toLowerCase().compareTo(farmArea2.showArea().toLowerCase());

			return value;
		}
	};

	/**
	 * Метод сравнения районов фермера по названию по убыванию
	 */
	public static Comparator<FarmerArea> nameDesc = new Comparator<FarmerArea>() {
		@Override
		public int compare(FarmerArea o1, FarmerArea o2) {
			FarmerArea farmArea1 = (FarmerArea) o1;
			FarmerArea farmArea2 = (FarmerArea) o2;
			int value = farmArea2.showArea().toLowerCase().compareTo(farmArea1.showArea().toLowerCase());

			return value;
		}
	};

	/**
	 * Метод сравнения районов фермера по коду по возрастанию
	 */
	public static Comparator<FarmerArea> codeAsc = new Comparator<FarmerArea>() {
		@Override
		public int compare(FarmerArea o1, FarmerArea o2) {
			FarmerArea farmArea1 = (FarmerArea) o1;
			FarmerArea farmArea2 = (FarmerArea) o2;
			int value = Long.compare(farmArea1.getAreaCode(), farmArea2.getAreaCode());

			return value;
		}
	};

	/**
	 * Метод сравнения районов фермера по коду по убыванию
	 */
	public static Comparator<FarmerArea> codeDesc = new Comparator<FarmerArea>() {
		@Override
		public int compare(FarmerArea o1, FarmerArea o2) {
			FarmerArea farmArea1 = (FarmerArea) o1;
			FarmerArea farmArea2 = (FarmerArea) o2;
			int value = Long.compare(farmArea2.getAreaCode(), farmArea1.getAreaCode());

			return value;
		}
	};

}
