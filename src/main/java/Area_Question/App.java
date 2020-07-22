package Area_Question;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class App
{
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(Epam_Serialization.App.class);

    public static Scanner obj = new Scanner(System.in);
    public static String getMaterial()
    {
        Logger.info("choose from type of materials : ");
        TypeOfMaterials[] typeofmaterials = TypeOfMaterials.values();
        for(TypeOfMaterials t : typeofmaterials)
        {
            Logger.info(t);
        }
        Logger.info("Enter :");
        String material = obj.next();
        return material;
    }
    public static void main( String[] args )
    {
        double area;
        String material;
        boolean automation = false;

        Logger.info("enter the area : ");
        area = obj.nextDouble();
        material = getMaterial();

        if(material.toLowerCase().equals(TypeOfMaterials.highStandardMaterials.toString().toLowerCase()))
        {
            Logger.info("is there automation :(yes/no)");
            automation = obj.nextBoolean();
        }

        Calculate calculate  = new Calculate();
        try{
            Logger.info(calculate.getInterest(area,material,automation));
        }
        catch(InvalidMaterialSelect e)
        {
            Logger.error(e);
        }
    }
}