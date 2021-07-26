import java.util.ArrayList;
import java.lang.Math;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Pot {
    private ArrayList<Flower> flowers;
    private int numberOfFlowers;
    private String shape;
    private int capacity;

    public Pot(String shape,int capacity){
        this.shape = shape.toLowerCase();
        this.capacity = capacity;
        this.numberOfFlowers = 0;
        flowers = new ArrayList<Flower>();
    }

    public String getShape(){return this.shape;}
////
    public boolean insert(Flower f){
        if(f==null || numberOfFlowers>=capacity){
            return false;
        }else{
            flowers.add(f);
            numberOfFlowers++;
        }
        return true;
    }

    public boolean contains(Flower f){
        if(f==null){
            if(this.size()-this.count()>0)
                return true;
            return false;
        }
        
        // String fColour = f.getColour();
        // String fSpecies = f.getSpecies();
        // double fAge = f.getAge();
        // double fHeight = f.getHeight();
        
        for(Flower a:flowers){
            // if(Math.abs(a.getAge()-fAge)<1.0 &&
            // Math.abs(a.getHeight()-fHeight)<0.001 ){
            //     if(a.getColour()==null && fColour==null){
            //         if(a.getSpecies()==null && fSpecies==null){
            //             return true;
            //         }else if(a.getSpecies()!=null && fSpecies!=null){
            //             if(a.getSpecies().equals(fSpecies))
            //                 return true;
            //         }
            //     }else if(a.getColour()!=null && fColour!=null){
            //         if(a.getSpecies()==null && fSpecies==null){
            //             return true;
            //         }else if(a.getSpecies()!=null && fSpecies!=null){
            //             if(a.getSpecies().equals(fSpecies))
            //                 return true;
            //         }
            //     }
            // }
            if(a.equals(f))
                return true;
        }
        return false;
    }
    public boolean containsType(String f){
        if(f==null) {
            for(Flower a:flowers){
                if(a.getSpecies()==null)
                    return true;
            }
            return false;
        }
        f = f.toLowerCase();
        for(Flower a:flowers){
            if(a.getSpecies()==null) continue;
            if(a.getSpecies().equals(f))
                return true;
        }
        return false;
    }
    public boolean containsColour(String f){
        if(f==null) {
            for(Flower a:flowers){
                if(a.getColour()==null)
                    return true;
            }
            return false;
        }
        f = f.toLowerCase();
        for(Flower a:flowers){
            if(a.getColour()==null) continue;
            if(a.getColour().equals(f))
                return true;
        }
        return false;
    }

    public int size(){return capacity;}

    public int count(){return numberOfFlowers;}

    public int countType(String t){
        int count = 0;
        if(t==null) {
            for(Flower a:flowers){
                if(a.getSpecies()==null)
                    count++;
            }
            return count;
        }
        t = t.toLowerCase();
        for(Flower a:flowers){
            if(a.getSpecies()==null) continue;
            if(a.getSpecies().equals(t))
                count++;
        }
        return count;
    }

    public int countColour(String t){
        int count = 0;
        if(t==null) {
            for(Flower a:flowers){
                if(a.getColour()==null)
                    count++;
            }
            return count;
        }
        t = t.toLowerCase();
        for(Flower a:flowers){
            if(a.getColour()==null) continue;
            if(a.getColour().equals(t))
                count++;
        }
        return count;
    }

    public String view(){
        String str = "";
        // int x = 0;
        if(this.count()==0)
            return str;
        TreeMap<String,Integer> tree_map = new TreeMap<>();
        for(Flower a:flowers){
            if(a.getColour()==null){
                // x=x+1;
                continue;
            }
            if(tree_map.get(a.getColour())==null)
                tree_map.put(a.getColour(), this.countColour(a.getColour()));
        }
        for (String key:tree_map.keySet()) {
            String value = (String)tree_map.get(key).toString();
            str = str + value +"x "+ key+"\n";
        }
        // str = str + x +"x "+ "null"+"\n";
        return str;
    }

    public void water(){
        if(this.count()==0)
            return;
        for(Flower a:flowers){
            a.growInside(this);
        }
    }

    public int rearrange(){
        int count = 0;

        for(Iterator<Flower> iterator = flowers.iterator(); iterator.hasNext();){
            //System.out.println(flowers.get(i).getSpecies()); 
            Flower f = iterator.next();
            if(f.isAlive()==false) {
                iterator.remove();
                numberOfFlowers--;
                count++;
            }        
        }
        return count;
    }

    public double averageAge(){

        if(this.count()==0)
            return -1.0;
        double sum = 0;
        int count = 0;
        for(Flower a:flowers){
            if(a.isAlive()){
                sum += a.getAge();
                count++;
            }
        }
        // System.out.println(sum+" "+count);
        if(count==0) return -1.0;
        return sum/count;
    }

    public double averageHeight(){
        if(this.count()==0)
            return -1.0;
        double sum = 0;
        int count = 0;
        for(Flower a:flowers){
            if(a.isAlive()){
                sum += a.getHeight();
                count++;
            }
        }
        if(count==0) return -1.0;
        return sum/count;
    }

    public Pot filterType(String t){
        Pot p = new Pot(this.getShape(),this.size());
        for(Iterator<Flower> iterator = this.flowers.iterator(); iterator.hasNext();){ 
            Flower f = iterator.next();
            if(f.getSpecies()==null || t==null){
                if(f.getSpecies()==null && t==null) 
                    p.insert(f.clone());  
            }else{
                if(f.getSpecies().equals(t.toLowerCase())) 
                    p.insert(f.clone());  
            }
        }
        return p;    
    }

    public Pot filterColour(String t){
        Pot p = new Pot(this.getShape(),this.size());
        for(Iterator<Flower> iterator = this.flowers.iterator(); iterator.hasNext();){ 
            Flower f = iterator.next();
            if(f.getColour()==null || t==null){
                if(f.getColour()==null && t==null) 
                    p.insert(f.clone());  
            }else{
                if(f.getColour().equals(t.toLowerCase())) 
                    p.insert(f.clone());  
            }
        }
        return p;   
    }

    public int replace(Flower f1,Flower f2){
        int count = 0;
        if(f1==null){
            if(f2!=null){
                int addMuliple_f2 = this.size()-this.count();
                for(int i = 0;i<addMuliple_f2;i++){
                    this.insert(f2.clone());
                    count++; 
                }
            }
        }else{
            for(Iterator<Flower> iterator = this.flowers.iterator(); iterator.hasNext();){ 
                Flower f = iterator.next();
                if(f.equals(f1)){
                    iterator.remove();
                    numberOfFlowers--;  
                    count++;
                }
            }
            if(f2!=null){
                for(int i = 0;i<count;i++){
                    this.insert(f2.clone());
                } 
            }
        }
        return count;
    }

    public int replaceType(String type,Flower f){
        int count = 0;
        if(type==null){
            if(f==null) return count;
            for(Iterator<Flower> iterator = this.flowers.iterator(); iterator.hasNext();){ 
                Flower a = iterator.next();
                if(a.getSpecies()==null){
                    iterator.remove();
                    numberOfFlowers--;  
                    count++;
                }
            }
            for(int i = 0;i<count;i++){
                this.insert(f.clone());
            } 
        }else{
            for(Iterator<Flower> iterator = this.flowers.iterator(); iterator.hasNext();){ 
                Flower a = iterator.next();
                if(a.getSpecies()==null) continue;
                if(a.getSpecies().equals(type)){
                    iterator.remove();
                    numberOfFlowers--;  
                    count++;
                }
            }
            if(f!=null){
                for(int i = 0;i<count;i++)
                    this.insert(f.clone());
            }
        }
        return count;
    }


    public int replaceColour(String colour,Flower f){
        int count = 0;
        if(colour==null){
            if(f==null) return count;
            for(Iterator<Flower> iterator = this.flowers.iterator(); iterator.hasNext();){ 
                Flower a = iterator.next();
                if(a.getColour()==null){
                    iterator.remove();
                    numberOfFlowers--;  
                    count++;
                }
            }
            for(int i = 0;i<count;i++){
                this.insert(f.clone());
            } 
        }else{
            if(f==null){
                for(Iterator<Flower> iterator = this.flowers.iterator(); iterator.hasNext();){ 
                    Flower a = iterator.next();
                    if(a.getColour()==null) continue;
                    if(a.getColour().equals(colour)){
                        iterator.remove();
                        numberOfFlowers--;  
                        count++;
                    }
                }
            }else{
                for(Iterator<Flower> iterator = this.flowers.iterator(); iterator.hasNext();){ 
                    Flower a = iterator.next();
                    if(a.getColour()==null) continue;
                    if(a.getColour().equals(colour)){
                        iterator.remove();
                        numberOfFlowers--;  
                        count++;
                    }
                }
                for(int i = 0;i<count;i++){
                    this.insert(f.clone());
                } 
            }
        }
        return count;
    }

    public static Pot combine(Pot p1,Pot p2){
        if(p1==null && p2==null) return null;
        if(p1==null) return p2;
        if(p2==null) return p1;

        Pot p = new Pot(p1.getShape(),100);

        for(Iterator<Flower> iterator = p1.flowers.iterator(); iterator.hasNext();){ 
            Flower f = iterator.next();
            if(f.getColour()==null) continue;
            if(!p.containsColour(f.getColour())){
                p.insert(f.clone());  
            }
        }
        
        for(Iterator<Flower> iterator = p2.flowers.iterator(); iterator.hasNext();){ 
            Flower f = iterator.next(); 
            if(f.getColour()==null) continue;
            if(!p.containsColour(f.getColour())){
                p.insert(f.clone());  
            }
        }
        p.capacity = p.count();
        return p;
    }

}
