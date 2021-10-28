package mul.com.a.dto;

import java.io.Serializable;

public class TempDto implements Serializable {
	
	private String name;
	private int number;
	private String birth;
	
	public TempDto() {
		
	}

	public TempDto(String name, int number, String birth) {
		super();
		this.name = name;
		this.number = number;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "TempDto [name=" + name + ", number=" + number + ", birth=" + birth + "]";
	}
	
	

}
