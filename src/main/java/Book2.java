import java.util.Objects;
import java.util.StringJoiner;

/**
 * Project name(项目名称)：反射访问成员变量
 * Package(包名): PACKAGE_NAME
 * Class(类名): Book2
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/29
 * Time(创建时间)： 16:56
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Book2
{
    String name;
    public int id;
    private float price;
    protected boolean isLoan;
    public char aChar;
    String address;
    public double sfg;


    public Book2()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        if (id >= 0)
        {
            this.id = id;
        }
        else
        {
            this.id = 0;
        }
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        if (price >= 0)
        {
            this.price = price;
        }
        else
        {
            this.price = 0;
        }
    }

    public boolean isLoan()
    {
        return isLoan;
    }

    public void setLoan(boolean loan)
    {
        this.isLoan = loan;
    }

    public char getaChar()
    {
        return aChar;
    }

    public void setaChar(char aChar)
    {
        this.aChar = aChar;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;

    }

    public Double getSfg()
    {
        return sfg;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, id, price, isLoan, aChar, address, sfg);
    }

    public void setSfg(Double sfg)
    {
        if (sfg >= 0)
        {
            this.sfg = sfg;
        }
        else
        {
            this.sfg = 0.0;
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("name：").append(name).append('\n');
        stringbuilder.append("id：").append(id).append('\n');
        stringbuilder.append("price：").append(price).append('\n');
        stringbuilder.append("isLoan：").append(isLoan).append('\n');
        stringbuilder.append("aChar：").append(aChar).append('\n');
        stringbuilder.append("address：").append(address).append('\n');
        stringbuilder.append("sfg：").append(sfg).append('\n');
        return stringbuilder.toString();
    }
}
