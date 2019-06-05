public class Ruler {
    public static  String rulerDraw(int level){
        if (level==1){
            return " -";
        }
        else {
            String slevel=" ";
            for (int i=0;i<level;i++){
                slevel=slevel.concat("-") ;
            }
            return  rulerDraw(level-1)+"\n"+slevel+"\n"+rulerDraw(level-1);
        }
    }
    public static void ruler(int inch,int level){
        String slevel=" ";
        for (int i=0;i<level;i++){
            slevel=slevel.concat("-") ;
        }
        for(int i=0;i<inch;i++){
            System.out.println(slevel+i+"\n"+rulerDraw(level));
        }
        System.out.println(slevel+inch);
    }
    public static void main(String[] args) {
        ruler(2,4);

    }
}
