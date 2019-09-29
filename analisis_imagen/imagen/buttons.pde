int rgbX=25;
int rgbY=480;
int lumaX=200;
int lumaY=480;
int histogramaX=375;
int histogramaY=480;
int identityX=580;
int identityY=480;
int sharpenX=760;
int sharpenY=480;
int edgeX=940;
int edgeY=480;
int northX=1120;
int northY=480;


void buttons(){
  pushStyle();

  rect(rgbX,rgbY,150,60);
  textSize(26);
  fill(0, 102, 153);
  text("rbg", rgbX+10,rgbY+32);

  fill(255);

  rect(lumaX,lumaY,150,60);
  textSize(26);
  fill(0, 102, 153);
  text("luma", lumaX+10,lumaY+32);

  fill(255);
  rect(histogramaX,histogramaY,180,60);
  textSize(26);
  fill(0, 102, 153);
  text("histograma", histogramaX+8,histogramaY+32);

  fill(0, 102, 153);   
  rect(identityX,identityY,150,60);
  textSize(26);
  fill(255); 
  text("identity", identityX+8,identityY+32);

  fill(0, 102, 153);   
  rect(sharpenX,sharpenY,150,60);
  textSize(26);
  fill(255); 
  text("sharpen", sharpenX+8,sharpenY+32);

  fill(0, 102, 153);   
  rect(edgeX,edgeY,150,60);
  textSize(26);
  fill(255); 
  text("edge", edgeX+8,edgeY+32);

  fill(0, 102, 153);   
  rect(northX,northY,150,60);
  textSize(26);
  fill(255); 
  text("north", northX+8,northY+32);

  popStyle();
}