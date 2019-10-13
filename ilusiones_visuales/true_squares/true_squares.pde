void setup(){
    size (670,450);
}
boolean show_circles=true;

void draw(){
    background(255);
    if (show_circles){
        circles();
    }

    squares();
}

void circles(){
    pushStyle();
    noFill();
    float rad=27.5;
    int [] x = {115,335,555};
    int [] y = {115,335};
        for (int i=0;i<6;i++){
            for (int j=0;j<8;j++){
                circle(x[i%3],y[i%2],rad*(j+1));
            }
        }
    popStyle();
}

void squares(){
    pushStyle();
    noFill();
    rectMode(CENTER);
    float extent=155.56;
    int [] x = {115,335,555};
    int [] y = {115,335};
    for (int i=0;i<6;i++){
        pushMatrix();
        translate(x[i%3], y[i%2]);
        rotate(PI/4.0);
        square(0,0,extent);
        popMatrix();
    }        
    popStyle();
}

void mousePressed(){
    if (show_circles){
        show_circles=false;
    }else{
        show_circles=true;
    }
}