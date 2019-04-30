package ua.com.zakharko.ihor.model;


import javax.persistence.*;

@Entity
@Table(name = "values", schema = "public")
public class QuadraticEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Integer a;

    @Column(nullable = false)
    private Integer b;

    @Column(nullable = false)
    private Integer c;

    @Column(nullable = false)
    private Double x1;

    private Double x2;

    public QuadraticEntity(){}

    public QuadraticEntity(final Integer a, final Integer b, final Integer c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Integer calculateD (){
        return b*b - 4*a*c;
    }

    public Boolean setAnswear(){
        if ((a != null && a != 0) && b != null && c != null){
            if (calculateD() >= 0){
                x1 = (-b + Math.sqrt(calculateD()))/(2*a);
                x2 = (-b - Math.sqrt(calculateD()))/(2*a);
                if (x1.equals(x2)) {
                    x2 = null;
                }
                return true;
            }
            return false;
        }
        else return false;
    }

    public Long getId()
    {
        return id;
    }

    public Integer getA()
    {
        return a;
    }

    public void setA(final Integer a)
    {
        this.a = a;
    }

    public Integer getB()
    {
        return b;
    }

    public void setB(final Integer b)
    {
        this.b = b;
    }

    public Integer getC()
    {
        return c;
    }

    public void setC(final Integer c)
    {
        this.c = c;
    }

    public Double getX1()
    {
        return x1;
    }

    public Double getX2()
    {
        return x2;
    }
}
