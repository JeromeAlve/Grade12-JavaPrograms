int w = 7, h= 11, bs =155; 
int last[]={0,0}; //yx
int[][]board = new int [h][w]; 

int player =1; 


void setup() 

{
  size(displayWidth,displayHeight);
  ellipseMode(CORNER); 
}

int p(int y, int x) 

{// p stands for piece 

  int a;

  if(y < 0 || x < 0|| y >= h || x >= w )

  {

   a=0;

  }

  else

  {

   a=board[y][x];

  }

  return a;

}


int getWinner() 

{ //check row 

for(int y = 0; y<h; y++)

  for(int x=0;x<w;x++)

    if (p(y,x) !=0 && p(y,x) == p(y,x+1) && p(y,x) == p(y,x+2) && p(y,x) == p(y,x+3)) 

       return p(y,x);


// check column

for(int y = 0; y<h; y++)

  for(int x=0;x<w;x++)

    if(p(y,x) !=0 && p(y,x)==p(y+1,x) && p(y,x)==p(y+2,x) && p(y,x)==p(y+3,x)) 

       return p(y,x); 

    

// check diagonal

for(int y = 0; y<h; y++)

  for(int x=0;x<w;x++) 

    for (int d= -1; d<= 1; d+=2)

     if(p(y,x) !=0  && p(y,x) == p(y+1*d,x+1)  && p(y,x) == p(y+2*d,x+2) && p(y,x) == p(y+3*d,x+3)) 

        return p(y,x); 

  //check for tie

for(int y = 0; y<h; y++)

 for(int x=0;x<w;x++)

  if (p(y,x)==0) return 0; //winner 

     return -1; // tie

}


// check where to drop the piece 

int nextSpace(int x)

{

  for(int y = h-1; y>=0; y--)

    if (board[y][x] == 0)

      return y;

      return -1; 

}


void mousePressed()

{

  int x = mouseX/bs;

  int y = nextSpace(x); 

  last[0]=y;

  last[1]=x;

  if(y>=0)

  {

    board[y][x] = player; 

    if(player == 1)//switch next player to move

    player=2;
    do{
    x=randomWithRange(0,6);
    }while(nextSpace(x)==-1);
    y= nextSpace(x);

    if(getWinner()==0)
    {
    board[y][x]= player;}
    player=1; 

 }
}



void draw() 

{
if(getWinner() ==0)

{

  for(int j =0; j<h; j++) 

   for(int i =0; i<w; i++)

   {  

    fill(240,48,48);//42,250,212); 

    rect(i * bs,j*bs,bs,bs); // grid

    

    if(board [j] [i] > 0)

    {

     fill(0, board [j][i] == 2?255:0,board[j][i] == 1?255:0); //colours of circles

     ellipse (i*bs,j*bs,bs,bs); 

    }

  }

 } 

 else // restart 

 {

   for(int j =0; j<h; j++) 

   for(int i =0; i<w; i++)

   {  

    fill(240,48,48); 

    rect(i * bs,j*bs,bs,bs); // grid

    

    if(board [j] [i] > 0)

    {

     fill(0, board [j][i] == 2?255:0,board[j][i] == 1?255:0); //colours of circles

     ellipse (i*bs,j*bs,bs,bs); 

    }

  }

   fill(0, board [last[0]][last[1]] == 2?255:0,board[last[0]][last[1]] == 1?255:0); //colours of circles

   ellipse (last[1]*bs,last[0]*bs,bs,bs); 

   

   String winner="";

   

   fill(255,255,255,80);

   rect(0,0,10000,10000);

   if(getWinner()==1)

   {

     winner="BLUE";

   }

   else

   {

     winner="GREEN";

   }

   fill(255);

   PFont mono;

   mono= loadFont("Aharoni-Bold-48.vlw");

   textFont(mono);

   text("Winner: " +winner + " PLAYER", 130,200); 

   text("(Tap here to restart)",130,400);
   mousePressed=false;
   

   if(mouseY<400)

   {

    player =1;

    for(int y = 0; y<h; y++)

     for(int x=0;x<w;x++) 

      board [y] [x] = 0; 

   }

 }
   fill(0);
   PFont mo;

   mo= loadFont("Aharoni-Bold-48.vlw");

   textFont(mo); 

   text("CONNECT 4     Created by Jerome Alve",100,1800);
}

int randomWithRange(int min, int max)
{
  int range= (max-min)+1;
  return (int)(Math.random()*range) + min;
}