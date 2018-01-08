package mongo.example.GsonExample;

public class Person
{
	private String name;
	private int age;
	private String email;
	private String phone;

	public Person()
	{}
	public Person(String name, int age, String email, String phone)
	{
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString()
	{
		return "Person [{name : "+name+", age : "+age+", email : "+email+", phone : "+phone+"}]";
	}
}
