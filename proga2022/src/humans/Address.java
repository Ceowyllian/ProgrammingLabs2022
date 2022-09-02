package humans;

public class Address {
	private String _country;
	private String _city;
	private String _street;
	private int _house;

	
	public Address(String _country, String _city, String _street, int _house) {
		super();
		this._country = _country;
		this._city = _city;
		this._street = _street;
		this._house = _house;
	}


	public String toString() {
		return this._country + ", " 
				+ this._city + ", " 
				+ this._street + ", " 
				+ this._house
				+ Integer.toString(this._house);
	}


	public String get_country() {
		return _country;
	}


	public void set_country(String _country) {
		this._country = _country;
	}


	public String get_city() {
		return _city;
	}


	public void set_city(String _city) {
		this._city = _city;
	}


	public String get_street() {
		return _street;
	}


	public void set_street(String _street) {
		this._street = _street;
	}


	public int get_house() {
		return _house;
	}


	public void set_house(int _house) {
		this._house = _house;
	}
	
	

}
