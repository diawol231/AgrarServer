package agrar.farmer.constants;

public enum TabKeys {

	FARMER("farmer", "Карточка фермера"),
	AREA("area", "Посевные районы");
	
	private final String name;
	private final String label;
	
	private TabKeys(String name, String label) {
		this.name = name;
		this.label = label;
	}

	public static String getTabNames() {
		StringBuilder sb = new StringBuilder();
		for(TabKeys item : TabKeys.values()) {
			sb.append(item.getName());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static String getTabLabels() {
		StringBuilder sb = new StringBuilder();
		for(TabKeys item : TabKeys.values()) {
			sb.append(item.getLabel());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	
	public String getName() {
		return this.name;
	}
	
	public String getLabel() {
		return this.label;
	}

}
