public class ScorpioFactory {

    public Scorpio createScorpio(char type) {
        switch(type) {
            case 'N': return new ScorpioN();

            case 'C': return new ScorpioClassic();

            default: return new Scorpio();
        }
    }
    //simpleFactory

}
 
ScorpioFactory factory = new ScorpioFactory();
Scorpio car1 = factory.createScorpio('D');


// but the twist is this is not the factory method. for sake of saying we can say that this is the  simple factory method .
// problem in this if else statement are there , which will make thing messy again .


 Collection<Scorpio> list =  new ArrayList<>();
        Scorpio car1 = new ScorpioN();
        Scorpio car2 = new ScorpioClassic();
        list.add(car1);
        list.add(car2);

        for(Scorpio car: list) {
            car.driveCar();
        }



// ################### this is factory methid ###################//
// we will create the interface for the engine and body shell then initialize 
// these variable in particular class  of the scoprpio and then generate car as we want 

import Models.IBodyShell;
import Models.IEngine;
import Models.ScorpioBodyShell;
import Models.ScorpioEngine;

public class Scorpio {

    IEngine engine; // engine interface we have intialized 
    IBodyShell bodyShell;  // body shell interface we have intialized 

    public void makeScorpio() {
        // here we are making the scorpio 
        System.out.println("Scorpio class me hu");
        this.engine = new ScorpioEngine();
        this.bodyShell = new ScorpioBodyShell();
        // to the interface object we have intialized the specifice engine and specifice 
        // body shell 
    }

    public void driveCar() {
        makeScorpio(); // this method basically acting as the factory method
        System.out.println("I am inside Scorpio Parent Class");
    }

}



// this  is the scorpio classic  cars 

public class ScorpioClassic extends Scorpio{

    @Override
    public void makeScorpio() {
        System.out.println("ScorpioClassic class me hu");
        this.engine = new ScorpioClassicEngine();
        this.bodyShell= new ScorpioClassicBodyShell();
    }

    public void driveCar() {
        makeScorpio();
        System.out.println("I am driving a ScorpioClassic");
    }
}

// this is scorpio N cars 

public class ScorpioN extends Scorpio {

    public void makeScorpio() {
        System.out.println("ScorpioN class me hu");
        this.engine = new ScorpioNEngine();
        this.bodyShell= new ScorpioNBodyShell();
    }
    public void driveCar() {
        makeScorpio();
        System.out.println("I am driving a ScorpioN");
    }
}




// when to use the factory method
// suppose i have a item and varaition starts coming in the factory method 
// like item1 , item2, item3. and i want to maintain all the variation with no code
// duplicay and using the code reuseability . then the factory method is used .









// actually this is called factory method 
