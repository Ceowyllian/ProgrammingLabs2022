package humans;


public class Human {
    private String _name;
    private String _surname;
    private int _age;
    private double _height;
    private double _weight;
    private boolean _habbits;
    private Nation _nation;
    private Address _adress;
	public Human(String _name, String _surname, int _age, double _height, double _weight, boolean _habbits,
			Nation _nation, Address _adress) {
		super();
		this._name = _name;
		this._surname = _surname;
		this._age = _age;
		this._height = _height;
		this._weight = _weight;
		this._habbits = _habbits;
		this._nation = _nation;
		this._adress = _adress;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_surname() {
		return _surname;
	}
	public void set_surname(String _surname) {
		this._surname = _surname;
	}
	public int get_age() {
		return _age;
	}
	public void set_age(int _age) {
		this._age = _age;
	}
	public double get_height() {
		return _height;
	}
	public void set_height(double _height) {
		this._height = _height;
	}
	public double get_weight() {
		return _weight;
	}
	public void set_weight(double _weight) {
		this._weight = _weight;
	}
	public boolean is_habbits() {
		return _habbits;
	}
	public void set_habbits(boolean _habbits) {
		this._habbits = _habbits;
	}
	public Nation get_nation() {
		return _nation;
	}
	public void set_nation(Nation _nation) {
		this._nation = _nation;
	}
	public Address get_adress() {
		return _adress;
	}
	public void set_adress(Address _adress) {
		this._adress = _adress;
	}
	@Override
	public String toString() {
		return _name + " " + _surname + ", " + _age + " y. o.";
	}
	
	
}
