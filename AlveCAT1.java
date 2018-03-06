import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class AlveCAT1 extends JFrame implements ActionListener
{
  public static void main (String [] args) throws IOException
  {
    //cool design
   try 
     { 
     UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
     } 
     catch(Exception e){ 
     }
     new AlveCAT1(); //start your application
    
    AlveCAT1 letterApp= new AlveCAT1();
    letterApp.setBounds(400,200,600,200);
    letterApp.setResizable(false);
    letterApp.setVisible(true);
  }
  
  
 
  JTextField inputText= new JTextField(50);//textfield for inputs
  
  //declaration and instantiation of radio buttons
  JRadioButton letters= new JRadioButton("Letter Count", true); 
  JRadioButton lengths= new JRadioButton("Length Count", false);
  JRadioButton words= new JRadioButton("Word Count", false); 
  
  ButtonGroup buttons= new ButtonGroup();
  JPanel buttonPanel= new JPanel();
    
  AlveCAT1()
  {
    setTitle("Word App");
    
    inputText.addActionListener(this);
    inputText.setEditable(true);                            
    
    //add action listener to buttons
    letters.addActionListener(this);
    lengths.addActionListener(this);
    words.addActionListener(this);
    
    //add buttons to button group
    buttons.add(letters);
    buttons.add(lengths);
    buttons.add(words);
    
    //add buttons to button panel
    buttonPanel.add(letters);
    buttonPanel.add(lengths);
    buttonPanel.add(words);
    
    buttonPanel.setBackground(Color.ORANGE);
    lengths.setBackground(Color.cyan);
    letters.setBackground(Color.cyan);
    words.setBackground(Color.cyan);
    
    getContentPane().setBackground(Color.cyan);
    
    setLayout(new FlowLayout());
    
    add(new JLabel(new ImageIcon("dog.png")));
    add(new JLabel("Input Phrase:")).setFont(new Font("",Font.BOLD, 15));;
    add(inputText);
    add(buttonPanel);

    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent evt)
  {
    String inputPhrase= inputText.getText();
    
    Shakespeare app= new CountLetters(inputPhrase); //object to count the occurences of every letter.
    
    if(letters.isSelected())
    {
      Object [][] chart = app.getOutput();//returns a 2-D array with values
      Object columns[] = { "Letter", "Occurences"};//headings of table
      
      JTable table= new JTable(chart, columns);//JTable parameters include a 2-D String array and the headings
      JScrollPane tableSP = new JScrollPane(table);//add table to scroll pane
      
      JFrame newFrame= new JFrame(); //new JFrame to add the table to.
      newFrame.setTitle("Counting Letters");
      newFrame.setVisible(true);
      newFrame.setSize(400,480);
      newFrame.add(tableSP);
    }
    
    app= new CountLength(inputPhrase);//2nd object with the same name (polymorphism) to count the occurences of each word length.
    
    if(lengths.isSelected())
    {
      Object [][] chart2 = app.getOutput();
      Object columns2 [] = { "Length", "Occurences"};//headings of the 2nd table
      
      JTable table2= new JTable(chart2, columns2);//JTable parameters include a 2-D String array and the headings
      JScrollPane tableSP2 = new JScrollPane(table2);
      
      JFrame newFrame2= new JFrame();//add table to a new JFrame also.
      newFrame2.setTitle("Counting Lengths");
      newFrame2.setVisible(true);
      newFrame2.setBounds(400,0,350,300);
      newFrame2.add(tableSP2);
    }
    
    app= new CountWords(inputPhrase);//3rd object to count the occurences of each word.
    
    if(words.isSelected())
    {
      Object [][] chart3 = app.getOutput();
      Object columns3 [] = { "Word", "Occurences"};//headings of 3rd table
      
      JTable table3= new JTable(chart3, columns3);
      JScrollPane tableSP3 = new JScrollPane(table3);
      
      JFrame newFrame3= new JFrame();//add table to a new JFrame.
      newFrame3.setTitle("Counting Words");
      newFrame3.setVisible(true);
      newFrame3.setBounds(755,0,400,400);
      newFrame3.add(tableSP3);
    }
  }
  
  
}

abstract class Shakespeare//parent abstract class
{
  protected String input;
  protected String [][] outputTable;//2D array for String values
  
  protected abstract void count();//method to calculate the occurences of letters/word lengths/words.
  protected abstract String [][] getOutput();//accessor method.
  
}

class CountLetters extends Shakespeare//counting occurences of each letter in a phrase
{

  int [] counters= new int[26];//counter array with 26 elements for each letter of the alphabet.
 
      
  
  CountLetters(String n)
  {
    input=n;
    count();
  }
  
  protected void count()
  {
    for(int aa=0; aa<input.length(); aa++) //loop to traverse through each character and count the occurences of each letter.
    {
      if(input.substring(aa,aa+1).equals("a")||input.substring(aa,aa+1).equals("A"))
      {
        counters[0]++;
      }
      if(input.substring(aa,aa+1).equals("b")||input.substring(aa,aa+1).equals("B"))
      {
        counters[1]++;
      }
      if(input.substring(aa,aa+1).equals("c")||input.substring(aa,aa+1).equals("C"))
      {
        counters[2]++;
      }
      if(input.substring(aa,aa+1).equals("d")||input.substring(aa,aa+1).equals("D"))
      {
        counters[3]++;
      }
      if(input.substring(aa,aa+1).equals("e")||input.substring(aa,aa+1).equals("E"))
      {
        counters[4]++;
      }
      if(input.substring(aa,aa+1).equals("f")||input.substring(aa,aa+1).equals("F"))
      {
        counters[5]++;
      }
      if(input.substring(aa,aa+1).equals("g")||input.substring(aa,aa+1).equals("G"))
      {
        counters[6]++;
      }
      if(input.substring(aa,aa+1).equals("h")||input.substring(aa,aa+1).equals("H"))
      {
        counters[7]++;
      }
      if(input.substring(aa,aa+1).equals("i")||input.substring(aa,aa+1).equals("I"))
      {
        counters[8]++;
      }
      if(input.substring(aa,aa+1).equals("j")||input.substring(aa,aa+1).equals("J"))
      {
        counters[9]++;
      }
      if(input.substring(aa,aa+1).equals("k")||input.substring(aa,aa+1).equals("K"))
      {
        counters[10]++;
      }
      if(input.substring(aa,aa+1).equals("l")||input.substring(aa,aa+1).equals("L"))
      {
        counters[11]++;
      }
      if(input.substring(aa,aa+1).equals("m")||input.substring(aa,aa+1).equals("M"))
      {
        counters[12]++;
      }
      if(input.substring(aa,aa+1).equals("n")||input.substring(aa,aa+1).equals("N"))
      {
        counters[13]++;
      }
      if(input.substring(aa,aa+1).equals("o")||input.substring(aa,aa+1).equals("O"))
      {
        counters[14]++;
      }
      if(input.substring(aa,aa+1).equals("p")||input.substring(aa,aa+1).equals("P"))
      {
        counters[15]++;
      }
      if(input.substring(aa,aa+1).equals("q")||input.substring(aa,aa+1).equals("Q"))
      {
        counters[16]++;
      }
      if(input.substring(aa,aa+1).equals("r")||input.substring(aa,aa+1).equals("R"))
      {
        counters[17]++;
      }
      if(input.substring(aa,aa+1).equals("s")||input.substring(aa,aa+1).equals("S"))
      {
        counters[18]++;
      }
      if(input.substring(aa,aa+1).equals("t")||input.substring(aa,aa+1).equals("T"))
      {
        counters[19]++;
      }
      if(input.substring(aa,aa+1).equals("u")||input.substring(aa,aa+1).equals("U"))
      {
        counters[20]++;
      }
      if(input.substring(aa,aa+1).equals("v")||input.substring(aa,aa+1).equals("V"))
      { 
        counters[21]++;
      }
      if(input.substring(aa,aa+1).equals("w")||input.substring(aa,aa+1).equals("W"))
      {
        counters[22]++;
      }
      if(input.substring(aa,aa+1).equals("x")||input.substring(aa,aa+1).equals("X"))
      {
        counters[23]++;
      }
      if(input.substring(aa,aa+1).equals("y")||input.substring(aa,aa+1).equals("Y"))
      {
        counters[24]++;
      }
      if(input.substring(aa,aa+1).equals("z")||input.substring(aa,aa+1).equals("Z"))
      {
        counters[25]++;
      }
    }
  }
  
  protected String [][] getOutput()
  {
    
    outputTable= new String [26][2];//output table has 2 columns and 26 rows; type String.
    
    for(int bb=0; bb<26;bb++)
    {
      outputTable[bb][1]=Integer.toString(counters[bb]);//convert the numbers to String and populate them to the 2nd column.
    }
    
    //populate the 1st column with the letters of the alphabet.
      outputTable[0][0]= "a";
      outputTable[1][0]= "b";
      outputTable[2][0]= "c";
      outputTable[3][0]= "d";
      outputTable[4][0]= "e";
      outputTable[5][0]= "f";
      outputTable[6][0]= "g";
      outputTable[7][0]= "h";
      outputTable[8][0]= "i";
      outputTable[9][0]= "j";
      outputTable[10][0]= "k";
      outputTable[11][0]= "l";
      outputTable[12][0]= "m";
      outputTable[13][0]= "n";
      outputTable[14][0]= "o";
      outputTable[15][0]= "p";
      outputTable[16][0]= "q";
      outputTable[17][0]= "r";
      outputTable[18][0]= "s";
      outputTable[19][0]= "t";
      outputTable[20][0]= "u";
      outputTable[21][0]= "v";
      outputTable[22][0]= "w";
      outputTable[23][0]= "x";
      outputTable[24][0]= "y";
      outputTable[25][0]= "z";
      
      
      return outputTable;//return 2D array.
    }
}

class CountLength extends Shakespeare//counts the occurences for each word length
{
  int [] lengthCounter= new int [20];//array counter that has a length of 20 (maximum word length is 20).
  
  CountLength(String n)
  {
    input=n;
    count();
  }
  
  
  protected void count()
  {
    Scanner freader= new Scanner(input);//use scanner to go through each word/token.
    
    while(freader.hasNext())//loop to count the occurences of each word length.
    {
      String word= freader.next();
      
      if(word.length()==1)
      {
        lengthCounter[0]++;
      }
      if(word.length()==2)
      {
        lengthCounter[1]++;
      }
      if(word.length()==3)
      {
        lengthCounter[2]++;
      }
      if(word.length()==4)
      {
        lengthCounter[3]++;
      }
      if(word.length()==5)
      {
        lengthCounter[4]++;
      }
      if(word.length()==6)
      {
        lengthCounter[5]++;
      }
      if(word.length()==7)
      {
        lengthCounter[6]++;
      }
      if(word.length()==8)
      {
        lengthCounter[7]++;
      }
      if(word.length()==9)
      {
        lengthCounter[8]++;
      }
      if(word.length()==10)
      {
        lengthCounter[9]++;
      }
      if(word.length()==11)
      {
        lengthCounter[10]++;
      }
      if(word.length()==12)
      {
        lengthCounter[11]++;
      }
      if(word.length()==13)
      {
        lengthCounter[12]++;
      }
      if(word.length()==14)
      {
        lengthCounter[13]++;
      }
      if(word.length()==15)
      {
        lengthCounter[14]++;
      }
      if(word.length()==16)
      {
        lengthCounter[15]++;
      }
      if(word.length()==17)
      {
        lengthCounter[16]++;
      }
      if(word.length()==18)
      {
        lengthCounter[17]++;
      }
      if(word.length()==19)
      {
        lengthCounter[18]++;
      }
      if(word.length()==20)
      {
        lengthCounter[19]++;
      }
    }
    
    
  }
  
  protected String [][] getOutput()
  {
    outputTable= new String[20][2];//table with 20 rows and 2 columns.
    
    
    for(int bb=0; bb<20;bb++)
    {
      outputTable[bb][0]=Integer.toString(bb+1);//column 1 contains the word length fromm 1-15.
      outputTable[bb][1]=Integer.toString(lengthCounter[bb]);//column 2 contains the occurences of each word length.
    }
   
   return outputTable;//return 2D String array.
   
  }
}


class CountWords extends Shakespeare//counts the occurences of each word
{
  
  CountWords(String in)
  {
    input=in;
    count();
    
  }
  
  protected void count()
  {
   
    int [] counter= new int [40];//counter that can count for 40 words maximum.
    outputTable= new String [40][2];//table will have a maximum of 40 rows
    String [] words= new String[40];//array to put the words that are inputted
     
     for(int x=0; x<40;x++)//populate the 2 String arrays with blanks
     {
       outputTable[x][0]=""; 
       words[x]="";
     }
     
    Scanner reader= new Scanner(input);//scanner to scan the input
    int a=0;
    
    while(reader.hasNext())//populate the words[] array with the inputted words
    {
      words [a]=(reader.next()).toLowerCase();
      a++;
    }
    
    int w=0;
    int z=0;
    
    //loop so that the same word wouldn't appear more than once in the output table
    
    for(int g=0; g<40; g++)
    {
      for(int h=0; h<40; h++)
      {
        if(words[g].equals(outputTable[h][0]))//if the word in the words[] array equals one of the words in the output table, variable 'z' will increase
        {
          z++;
        }
      }
      if(z<1)//if variable 'z' is less than 1, which means that the word is not on the output table yet.
      {
        outputTable[w][0]=words[g];//add the current word to the output table
        w++;// variable 'w' goes up to the next position of the output table
      }
      z=0;//reset variable 'z' to zero.
    }

     
    //loop to count the occurences of each word
    
   for(int cc=0; cc<40; cc++)
    {
     for(int dd=0; dd<40; dd++)
     {
       if(outputTable[cc][0].equals(words[dd])&&!outputTable[cc][0].equals(""))
         //if the word on the output table equals a word on the word[] array, the counter will increase.
         //blanks ("") will not be counted
       {
         counter[cc]++; 
       }
      }
      
    }
    
    
   //loop to populate the 2nd column of the outputTable[] array
   for(int bb=0; bb<40;bb++)
    {
      outputTable[bb][1]=Integer.toString(counter[bb]);
      
      if(outputTable[bb][1].equals("0"))//if the value is "0", convert it to blank "";
      {
        outputTable[bb][1]="";
      }
    }
    
    
  }
  protected String [][] getOutput()
  {
    return outputTable;//return 2D array
  }
}