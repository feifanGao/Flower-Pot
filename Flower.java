import java.lang.Math;
public class Flower {
    private String colour;
    private String species;
    private double age;
    private int maxAge;
    private double maxHeight;

    public Flower(String colour,String species,int mAge,double mHeight){
        this.colour = (colour != null) ? colour.toLowerCase() : null;
        this.species = (species != null) ? species.toLowerCase() : null;
        age = 0;
        maxAge = mAge;
        maxHeight = mHeight;
    }

    public Flower(String colour,String species,double age,int mAge,double mHeight){
        this.colour = (colour != null) ? colour.toLowerCase() : null;
        this.species = (species != null) ? species.toLowerCase() : null;
        this.age = age;
        maxAge = mAge;
        maxHeight = mHeight;
    }
    
    //
    public boolean grow(){
        if(this.isAlive())
            age++;
        else
            return false;
        if(this.isAlive())   
            return true;
        return false;
    }   

    public boolean growInside(Pot p){
        if(this.isAlive())
            age = age+1+0.5*Math.min(p.size()-p.count(),5);
        else
            return false;

        if(this.isAlive())   
            return true;
        return false;
        // if(p.contains(this))
        //     return true;
        // return false;
    }

    public boolean isAlive(){
        if((maxAge-age)<0 || age<0 || maxAge<0)
             return false;
        return true;
    }

    public String getColour(){
        return this.colour;
    }

    public String getSpecies(){
        return this.species;
    }

    public double getAge(){
        if(this.age<0)
            return -1;
        return this.age;
    }

    public int getMaxAge(){
        return this.maxAge;
    }

    public double getMaxHeight(){
        return this.maxHeight;
    }

    public double getHeight(){
        return Math.min(maxHeight, (2/Math.PI) * Math.atan(age/maxHeight) * maxHeight);
    }

    public void die(){
        age = -1;
    }

    //todo
    public boolean equals(Flower a){
        String fColour = this.getColour();
        String fSpecies = this.getSpecies();
        double fAge = this.getAge();
        double fHeight = this.getHeight();

        if(Math.abs(a.getAge()-fAge)<1.0 &&
            Math.abs(a.getHeight()-fHeight)<0.001 ){
                if(a.getColour()==null && fColour==null){
                    if(a.getSpecies()==null && fSpecies==null){
                        return true;
                    }else if(a.getSpecies()!=null && fSpecies!=null){
                        if(a.getSpecies().equals(fSpecies))
                            return true;
                    }
                }else if(a.getColour()!=null && fColour!=null){
                    if(a.getSpecies()==null && fSpecies==null){
                        return true;
                    }else if(a.getSpecies()!=null && fSpecies!=null){
                        if(a.getSpecies().equals(fSpecies))
                            return true;
                    }
                }
        }
        return false;
    }

    public Flower clone(){
        Flower f = new Flower(this.getColour(),this.getSpecies(),this.getAge(),this.getMaxAge(),this.getMaxHeight());
        return f;
    }
    
}
