package yarrou.app;

public class Products {
	private String name;
	private Double energo;
	private Double belki;
	private double jiri;
	private double uglevodi;
	private String putIcon;
	public String getName(){
		return name;
	}
	public void setName(String nm){

		this.name=nm;
	}
	public Double getEnergo(){
		return energo;
	}
	public void setEnergo(Double en){
		this.energo=en;
	}
	public Products(String n, double e, double b, double j, double u,String ic){
		this.setName(n);
		this.setEnergo(e);
		this.setBelki(b);
		this.setJiri(j);
		this.setUglevodi(u);
		this.setPutIcon(ic);

	}
	public Double getBelki(){
		return belki;
	}
	public void setBelki(double bl){
		this.belki=bl;
	}
	public Double getJiri(){
		return jiri;
	}
	public void setJiri(double jr){
		this.jiri=jr;
	}
	public Double getUglevodi(){
		return uglevodi;
	}
	public void setUglevodi(double ug){
		this.uglevodi=ug;
	}
	public String getPutIcon(){
		return putIcon;
	}
	public void setPutIcon(String ic){
		this.putIcon=ic;
	}

	public String vivod(String x , double y  ){
		String fraza=("енергетическая ценность 100 грамм продукта "+ x +"\n"+" равна "+ y + " килокалорий");
	return fraza;
}}
