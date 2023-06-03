import java.util.*;

 class Job implements Comparable<Job> {
    int jid;
    int dl;
    int p;
    Job(int jid,int dl,int p){
        this.jid=jid;
        this.dl=dl;
        this.p=p;
    }
    public int compareTo( Job obj){
        return (obj.p-this.p);
    }
}
public class Jobsq{
    public static  void MaxProfits(List<Job> A,int n){
        Collections.sort(A);
        boolean[] p=new boolean[n];
        //Arrays.fill();
        int tp=0;
        for(int j=0;j< A.size();j++) {
            for (int i = A.get(j).dl-1; i >= 0; i--) {
                if (!p[i]){
                    tp=tp+ A.get(j).p;
                    p[i]=true;
                    break;
                }

            }
        }
        System.out.println(tp);




    }
    public static void main(String args[]){
        List<Job> A=new ArrayList<Job>();
        A.add(new Job('A',2,100));
        A.add(new Job('B',1,20));
        A.add(new Job('C',2,40));
        A.add(new Job('D',1,80));
        A.add(new Job('E',3,60));
        MaxProfits(A,3);



    }
}

