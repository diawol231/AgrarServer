package agrar.type;

public enum OrgForm {

	MALE(1, "Мужчины"),
	FEMALE(2, "Женщины"),
	YOUNG_MALE(3, "Юноши"),
	YOUNG_FEMALE(4, "Девушки"),
	JUNIOR_MALE(5, "Юниоры"),
	JUNIOR_FEMALE(6, "Юниорки"),
	BOY(7, "Мальчики"),
	GIRL(8, "Девочки");

	private final int id;
	private final String label;

	private OrgForm(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public static OrgForm findById(int id) {
		for(OrgForm item : OrgForm.values())
			if(item.getId() == id)
				return item;
		throw new IllegalArgumentException("Unknown OrgForm id:" + id);
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getLabel() {
		return this.label;
	}
	
}
