# Taller de análisis de imágenes por software

## Propósito

Introducir el análisis de imágenes/video en el lenguaje de [Processing](https://processing.org/).

## Tareas

Implementar las siguientes operaciones de análisis para imágenes/video:

* Conversión a escala de grises: promedio _rgb_ y [luma](https://en.wikipedia.org/wiki/HSL_and_HSV#Disadvantages).
* Aplicación de algunas [máscaras de convolución](https://en.wikipedia.org/wiki/Kernel_(image_processing)).
* (solo para imágenes) Despliegue del histograma.
* (solo para imágenes) Segmentación de la imagen a partir del histograma.
* (solo para video) Medición de la [eficiencia computacional](https://processing.org/reference/frameRate.html) para las operaciones realizadas.

Emplear dos [canvas](https://processing.org/reference/PGraphics.html), uno para desplegar la imagen/video original y el otro para el resultado del análisis.

### Alternativas para video en Linux y `gstreamer >=1`

Distribuciones recientes de Linux que emplean `gstreamer >=1`, requieren alguna de las siguientes librerías de video:

1. [Beta oficial](https://github.com/processing/processing-video/releases).
2. [Gohai port](https://github.com/gohai/processing-video/releases/tag/v1.0.2).

Descompriman el archivo `*.zip` en la caperta de `libraries` de su sketchbook (e.g., `$HOME/sketchbook/libraries`) y probar cuál de las dos va mejor.

## Integrantes

Completar la tabla:

| Integrante | github nick |
|------------|-------------|
| bryan vega |bdvegat      |

## Discusión
- Se aprendio sobre los tipos de canvas que ofrece processing y sobre como interactuar con ellos.
- Aplicando las tecnicas de conversion a escala de grises se entiende mejor como funciona el espacio de color RGB.
- Se realizaron operaciones de convolucion sobre imagenes y videos para obtener las mascaras de convolucion, que ayudan a tener perspectivas diferentoes sobre las imagenes y resaltar pixles con propiedades de interes.
- Aplicando el metodo para obtener el histograma se entiende mejor como funciona el espacio de color HSB, como se pueden usar PGraphics como capas y se entiende el histograma como una herramienta que permite realizar analisis sobre imagenes.
- Se hicieron operacion sobre pixeles de imagenes y videos que ayudaron a aprender sobre el funcionamiento de proccesing, como es el flujo para dibujar sobre un frame PGraphics, como se puede manipular una imagen o video  a nivel de pixeles.

## Referencias
rgb grayscale https://www.johndcook.com/blog/2009/08/24/algorithms-convert-color-grayscale/
luma grayscale https://www.researchgate.net/figure/Luma-Grayscale-conversion-pseudo-code_fig2_288824333
convolution https://en.wikipedia.org/wiki/Convolution
kernels de convolucion https://www.sciencedirect.com/topics/computer-science/convolution-filter
codigo de convolucion adaptado de: https://processing.org/examples/convolution.html
codigo histograma adaptado de: https://processing.org/examples/histogram.html


## Entrega

* Plazo para hacer _push_ del repositorio a github: 29/9/19 a las 24h.
