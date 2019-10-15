PImage background;
PImage monster;
void setup(){
    size (640,480);
}
boolean show_background=true;

void draw(){
    background = loadImage("arizona-asphalt-beautiful-490466.jpg");
    monster = loadImage("werewolf-1566753_640.png");
    monster.resize(0,200);
    if (show_background){
        image(background, 0, 0);
    }else{
        background(255);
    }
    image(monster,250,50);
    image(monster,250,280);
}


void mousePressed(){
    if (show_background){
        show_background=false;
    }else{
        show_background=true;
    }
}