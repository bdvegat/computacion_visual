color convolution (float[][]kernel,int x,int y){
  int kLength=kernel.length;
  float r=0;
  float g=0;
  float b=0;
  for(int i=0;i<kLength;i++){
    for (int j=0;j<kLength;j++){
      int row=x-int(kLength/2)+i;
      int column=y-int(kLength/2)+j;
      int pos=row*photo.width+column;
      if (row>=0 && column>=0 && row<photo.height && column<photo.width){
        r+=int(kernel[kLength-i-1][kLength-j-1])*red(photo.pixels[pos]);
        g+=int(kernel[kLength-i-1][kLength-j-1])*green(photo.pixels[pos]);
        b+=int(kernel[kLength-i-1][kLength-j-1])*blue(photo.pixels[pos]);
        }else{
        continue;
      }
    }
  }
  r=constrain(r,0,255);
  g=constrain(g,0,255);
  b=constrain(b,0,255);
  return color(r,g,b);
}