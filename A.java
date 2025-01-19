class A{
int x=10;
int y =20;

public void m1()
{
System.out.println("m1 method");
int y=20;
System.out.println(y);
}

public static void main(String[] args)
{
System.out.println("Main method");
A a= new A();
System.out.println(a.x);
a.m1();
System.out.print("hi");


}
}
