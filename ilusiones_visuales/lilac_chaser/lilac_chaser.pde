void setup(){
    size (640,640);
    frameRate(10);

}
boolean show_circles=true;

int k=0;
void draw(){
    background(255);
    circles(k);
    k++;
    if (k==12){
        k=0;
    }
}

void circles(int k){
    pushStyle();
    line(310,320,330,320);
    line(320,310,320,330);
    fill(255,102,178);
    float rad=60;
    float [] deg ={0,30,60,90,120,150,180,210,240,270,300,330};
    float current;
    translate(320, 320);
        for (int i=0;i<12;i++){
            pushMatrix();
            current=deg[i];
            rotate(radians(current));
            println("current: "+current);
            if (i!=k){
                circle(0,150,rad);
            }
            popMatrix();
        }
    popStyle();
}

