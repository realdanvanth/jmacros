import java.io.*;
public class macros{
  static String lines[];
  public static void main(String args[])throws FileNotFoundException,IOException{
    BufferedReader br = new BufferedReader(new FileReader(args[0]));
    String line = br.readLine();
    String code = "";
    while(line!=null){
      code+="\n"+line;
      line = br.readLine();
    }
    lines = code.split("\n");
    for(int i=0;i<lines.length;i++){ 
      if(lines[i].contains("@macro")){ 
        resolveMacro(lines[i].substring(lines[i].indexOf("@macro")+7),i);
      }
    } 
    /*for(int i = 0;i<lines.length;i++){
      System.out.println(lines[i]);
    }*/
  }
  public static void resolveMacro(String line,int i){
    String macro = line.split(" ")[0];
    lines[i] = "";
    switch (macro) {
      case "def": 
        def(line.substring(4));
        break;
      default:
        System.out.println("Unkown Macro at line: "+i+" "+macro);
        System.exit(0);
        break;
    }
  }
  public static void def(String line){ 
    String define []= line.split("= "); 
    for(int i = 0;i<lines.length;i++){
      lines[i] = lines[i].replace(define[0].trim(), define[1].trim());
      if(lines[i]!="")
      System.out.println(lines[i]);
    }
  }
}
