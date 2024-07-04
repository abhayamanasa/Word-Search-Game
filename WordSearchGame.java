import javax.swing.*;   
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.table.*;
import java.io.*;
public class TableExample1 extends MouseAdapter 
{
    String[] words=new String[14];    
    JTextField tf[]=new JTextField[12];
    JFrame f; 
    int count=0;
    TableExample1() throws Exception
    {    
        words[0]="SIMPLE";
        words[1]="ROBUST";
        words[2]="OBJECTORIENTED";
        words[3]="PORTABLE";
        words[4]="PLATFORMINDEPENDANT";
        words[5]="SECURED";
        words[6]="INTERPRETED";
        words[7]="HIGHPERFORMANCE";
        words[8]="MULTITHREAD";
        words[9]="DISTRIBUTED";
        words[10]="DYNAMIC";
        words[11]="ARCHITECTURENEUTRAL";
        for(int i=0;i<12;i++)
           tf[i]=new JTextField(words[i]);
    f=new JFrame();    
    f.setLayout(null);
    f.setSize(1280,670);  
    f.setVisible(true);
    f.setBackground(Color.BLACK);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Color c=new Color(3,14,79);
    f.setBackground(c);
    f.getContentPane().setBackground(c);
    JLabel label = new JLabel("WORD SEARCH");
    Font font = new Font("Courier", Font.BOLD,48);
    label.setBounds(450,20,600,50);
    label.setFont(font);
    f.add(label);
    Color x= new Color(244,159,28);
    label.setForeground(x);
    tf[0].setBounds(300,430,160,25);
    tf[1].setBounds(475,430,160,25);
    tf[2].setBounds(650,430,160,25);
    tf[3].setBounds(825,430,160,25);
    tf[4].setBounds(300,465,160,25);
    tf[5].setBounds(475,465,160,25);
    tf[6].setBounds(650,465,160,25);
    tf[7].setBounds(825,465,160,25);
    tf[8].setBounds(300,500,160,25);
    tf[9].setBounds(475,500,160,25);
    tf[10].setBounds(650,500,160,25);
    tf[11].setBounds(825,500,160,25);
    for(int i=0;i<12;i++)
    {
        tf[i].setEditable(false);
        f.add(tf[i]);
    }
    Object data[][] = { 
        {"P","L","A","T","F","O","R","M","I","N","D","E","P","E","N","D","A","N","T"},
        {"O","L","M","P","O","R","T","A","B","L","E","X","C","E","P","T","I","O","N"},
        {"O","C","I","N","T","O","B","J","E","C","T","O","R","I","E","N","T","E","D"},
        {"E","I","D","E","T","E","R","P","R","E","T","N","I","N","U","L","L","R","J"},
        {"L","M","S","T","R","I","N","G","D","I","S","T","R","I","B","U","T","E","D"},
        {"P","A","O","M","U","L","T","I","T","H","R","E","A","D","O","I","F","P","A"},
        {"M","N","C","M","A","R","R","O","B","U","S","T","H","R","E","A","D","U","V"},
        {"I","Y","E","N","U","M","C","L","A","S","S","E","C","U","R","E","D","S","A"},
        {"S","D","H","I","G","H","P","E","R","F","O","R","M","A","N","C","E","O","J"},
        {"A","R","C","H","I","T","E","C","T","U","R","E","N","E","U","T","R","A","L"}
};    
String column[] = {"","","","","","","","","","","","","","","","","","",""};         
JTable jt = new JTable(data, column);  
jt.setBounds(450,100,380,300);
jt.setCellSelectionEnabled(true);
jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jt.setRowHeight(30);

for (int i = 0; i < 19; i++) {
     TableColumn column1 = jt.getColumnModel().getColumn(i);
    column1.setPreferredWidth(20);
    column1.setMinWidth(10);
    column1.setMaxWidth(20);
    //System.out.println("Column " + i + " width: " + jt.getColumnModel().getColumn(i).getWidth());
}
f.add(jt);

    jt.setSelectionBackground(Color.LIGHT_GRAY);
    jt.setShowGrid(false);
    jt.addMouseListener(new MouseAdapter(){
        public void mouseReleased(MouseEvent me)
        {
          int[] selectedRows = jt.getSelectedRows();
                int[] selectedColumns = jt.getSelectedColumns();
                StringBuilder sb = new StringBuilder();
                Random rand = new Random();
                            int red = rand.nextInt(56) + 200;  
                            int green = rand.nextInt(56) + 200; 
                            int blue = rand.nextInt(56) + 200;
                for (int i = 0; i < selectedRows.length; i++) {
                    for (int j = 0; j < selectedColumns.length; j++) {
                        Object cellData = jt.getValueAt(selectedRows[i], selectedColumns[j]);
                        sb.append(cellData.toString());
                    }
                }
                String s2=sb.toString();
                StringBuffer sb1=new StringBuffer(s2);
                sb1.reverse();
                for(int k=0;k<12;k++)
                {
                    if((sb.toString()).equals(words[k]))
                    {
                        words[k]=null;
                            Color randomColor = new Color(red, green, blue);
                            jt.setSelectionBackground(randomColor);
                            tf[k].setBackground(randomColor);
                            count++;
                            break;
                        }
                    else if((sb1.toString()).equals(words[k]))
                    {
                        words[k]=null;
                            Color randomColor = new Color(red, green, blue);
                            jt.setSelectionBackground(randomColor);
                            tf[k].setBackground(randomColor);
                            count++;
                            break;
                    }
                }
                if(count==6)
                {
                    JOptionPane.showMessageDialog(f,"Snap,crackle and pop");
                }
                if(count==9)
                {
                    JOptionPane.showMessageDialog(f,"Imagination at finest,just do it");
                }
                if(count==12)
                {
                    JOptionPane.showMessageDialog(f,"You’re finally here,the breakfast of champions");
                }
            }
        });
}
public static void main(String[] args) throws Exception
{    
    new TableExample1();    
}    
}  