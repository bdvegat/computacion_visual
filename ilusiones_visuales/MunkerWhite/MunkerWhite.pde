PGraphics left;
PGraphics rigth;

void setup(){
    size (640,480);
}
boolean show_background=true;

void draw(){
    left();
    rigth();
}

void left(){

}

void rigth(){

}

// blueLines(PGraphics pg){
//     pushStyle();
//     pg.beginDraw();
//     int wide = 320;
//     fill(0,0,204);
//     strokeWeight(10);
    
//     for (int i=1;i<wide/2;i+=2*10){
//         line(i,0,i,320);
//     }
//     pg.endDraw();
//     popStyle();
// }

// redLines(PGraphics pg){
//     pushStyle();
//     pg.beginDraw();
//     int wide = 320;
//     fill(255,255,51);
//     strokeWeight(10);
//     for (int i=0;i<wide/2;i+=2*10){
//         line(i,0,i,320);
//     }
//     pg.endDraw();
//     popStyle();
// }

// void mousePressed(){
//     if (show_background){
//         show_background=false;
//     }else{
//         show_background=true;
//     }
// }