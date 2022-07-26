package agrar.farmer.type;

public enum OrgForm {

	OOO(1, "Общество с ограниченной ответственностью"),
	PAO(2, "Публичное акционерное общество"),
	NAO(3, "Непубличное акционерное общество"),
	UP(4, "Унитарное предприятие"),
	IP(5, "Индивидуальный предприниматель"),
	FL(6, "Физическое лицо");

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
