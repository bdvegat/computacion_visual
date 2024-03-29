PGraphics left;
PGraphics rigth;

void setup(){
    size (640,480);
    left=createGraphics(320,480);
    rigth=createGraphics(320,480);
}
boolean show_background=true;

void draw(){
    left();
    rigth();
    image(left,0,0);
    image(rigth,320,0);
}

void left(){
    if (show_background){
        blueLines(left);
        redCircle(left);
        yellowLines(left);
    }else{
        left.beginDraw();
        left.background(255);
        left.endDraw();
        redCircle(left);
    }
}

void rigth(){
    if (show_background){
        yellowLines(rigth);
        redCircle(rigth);
        blueLines(rigth);
    }else{
        rigth.beginDraw();
        rigth.background(255);
        rigth.endDraw();
        redCircle(rigth);
    }
}

void blueLines(PGraphics pg){
    pushStyle();
    pg.beginDraw();
    int wide = 320;
    pg.stroke(0,0,204);
    int j=0;
    for (int i=0;i<wide;i+=1){
        j+=1;
        if(j>9){
            pg.line(i,0,i,480);
        }
        if (j==19) {
            j=0;
        }
    }
    pg.endDraw();
    popStyle();
}

void yellowLines(PGraphics pg){
    pushStyle();
    pg.beginDraw();
    int wide = 320;
    pg.stroke(255,255,51);
    int j=0;
    for (int i=0;i<wide;i+=1){
        j+=1;
        if(j<10){
            pg.line(i,0,i,480);
        }else if (j==19) {
            j=0;
        }
    }
    pg.endDraw();
    popStyle();
}

void mousePressed(){
    if (show_background){
        show_background=false;
    }else{
        show_background=true;
    }
}

void redCircle(PGraphics pg){
    pushStyle();
    pg.beginDraw();
    pg.stroke(255,0,0);
    pg.fill(255,0,0);
    pg.circle(160,240,200);
    pg.endDraw();
    popStyle();
}