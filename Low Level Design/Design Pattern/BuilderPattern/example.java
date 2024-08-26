// this method is used when we have to build the aggreagte and composite object 
// when there is step by step process to create the object // series of steps
// when you want to hide the process of the creation object

// usecase 
// when we creating multiple constructor acc to the requirement then we are using
// builder design pattern


// adv
// we can create the diff type of object with the same construction process


// example
// aircraft -> series of steps are include in this to make the aircraft 
// add engine, add wings, add pantry , add interior, add bathroom


//two major player in this
// director _> which basically guide when you have to perform the steps
// builder _>  this is basically the actual implementation 



// now let see the code implementation 

public interface ICar {
}
public class Fortuner implements ICar{
}
public class Scorpio implements ICar{
}


public interface ICarBuilder {
    public void buildEngine() ;
    public void buildChassis() ;
    public void buildTyre() ;
    public void buildBodyShell() ;
    public ICar build() ;
}
public class FortunerBuilder implements ICarBuilder{

    Fortuner s1;
    @Override
    public void buildEngine() {
        System.out.println("Fortuner Engine getting inserted");
    }

    @Override
    public void buildTyre() {
        System.out.println("Fortuner Tyre getting inserted");
    }

    @Override
    public void buildChassis() {
        System.out.println("Fortuner Chassis getting inserted");
    }

    @Override
    public void buildBodyShell() {
        System.out.println("Fortuner Body getting inserted");
    }

    @Override
    public ICar build() {
        return s1;
    }
}
public class ScorpioBuilder implements ICarBuilder{

    Scorpio s1;
    @Override
    public void buildEngine() {
        //s1.engine = new ScorpioEngine();
        System.out.println("Scorpio Engine getting inserted");
    }

    @Override
    public void buildTyre() {
        //s1.tyre = new SCorpioTyre();
        System.out.println("Scorpio Tyre getting inserted");
    }

    @Override
    public void buildChassis() {
        //s1.Chassis = new SCorpioChassis();
        System.out.println("Scorpio Chassis getting inserted");
    }

    @Override
    public void buildBodyShell() {
        //s1.body = new SCorpioBodyShell();
        System.out.println("Scorpio Body getting inserted");
    }

    @Override
    public ICar build() {
        System.out.println("Scorpio tyaar h, le jao");
        return s1;
    }
}



public class Director {

    ICarBuilder carBuilder;

    public Director(ICarBuilder builder) {
        this.carBuilder = builder;
    }

    //instruction
    public void construct(boolean tyreNeeded, boolean engineNeeded, boolean bodyNeeded) {
        if(engineNeeded) {
            carBuilder.buildEngine();
        }

        if(tyreNeeded) {
            carBuilder.buildTyre();
        }

        carBuilder.buildChassis();
        if(bodyNeeded) {
            carBuilder.buildBodyShell();
        }

    }
}

public class Main {
    public static void main(String[] args) {
        ICarBuilder builder = new ScorpioBuilder();
        Director director = new Director(builder);
        //guidance dedo
        director.construct(false, false, false);

        ICar car = builder.build();

    }
}

// with the help of the same code  i can make fortuner and scorpio as needed 
/// this is the adv of the builder method pattern 

//  how it is handling the anti pattern case scenrio by passing the boolean 
// value and then building acc to the value is passed 