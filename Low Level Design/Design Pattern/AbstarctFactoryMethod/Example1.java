// this mehtod is used solves the problem of the creating family of related products 
//                                car 
//            scorpio         safari        defender       boloero 
//           4 variation     3 variiation    2 variation    3 variation
// in this specific use case i am going to use the abstract factory methosd 

//  client -> interact with abstarct layer class -> have intercation with the scorpio and 
// defendar class . this is called abstarct factory pattern 



// this is the  modals of the code
public interface IEngine {
}
public class ScorpioEngine implements IEngine{
}
public class DefenderEngine implements IEngine{
}



public interface IVehicleFactory {

    public IEngine createEngine();
}
public class DefenderFactory implements IVehicleFactory{

    public IEngine createEngine() {
        System.out.println("Defender ka Engine bana rha hu");
        return new DefenderEngine();
        // now think about if variation happen in defendar class , there are 2 types 
        // of the defendar , one is d90 and other is d120. then how you will figure
        // out ki which defender engine has to return 
    }
}
public class ScorpioFactory implements IVehicleFactory{

    public IEngine createEngine() {
        System.out.println("Scorpio ka engine bana raha hu");
        return new ScorpioEngine();
    }
}
public class Car {

    IEngine engine;
    IVehicleFactory carFactory;

    Car(IVehicleFactory factory) {
        this.carFactory = factory; // this is very imp step 
    }

    public void driveCar() {
        engine = carFactory.createEngine();
        System.out.println("MIlgyi gaadi, chillll maro");
    }

}

public class Main {
    public static void main(String[] args) {

        IVehicleFactory factory1 = new ScorpioFactory();
        IVehicleFactory factory2 = new DefenderFactory();
        Car car1 = new Car(factory1);
        Car car2  = new Car(factory2);

        Collection<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);

        for(Car c: list) {
            c.driveCar();
        }

    }
}
