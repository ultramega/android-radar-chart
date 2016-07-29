# Android Radar Chart

This library provides a View that renders a radar chart and a widget for editing the values in the chart.

## Installation

Add the dependency to your module's **build.gradle** file:

    dependencies {
        compile 'com.ultramegasoft.radarchart:radar-chart:0.1.0'
    }

## Documentation

Full Java reference is available at https://ultramega.github.io/android-radar-chart/.

### XML Attributes

#### RadarView

| Name                    | Type    | Default                | Description                                                           |
|-------------------------|---------|------------------------|-----------------------------------------------------------------------|
| circleColor             | Color   | #FFCCCCCC              | The color for the circles                                             |
| gravity                 | Gravity | center_horizontal\|top | The alignment of the View within its container                        |
| labelColor              | Color   | #FFFFFFFF              | The color for the label text                                          |
| polygonColor            | Color   | #DD0066FF              | The color for the polygon representing the data in the chart          |
| polygonColorInteractive | Color   | #DDFF66FF              | The color for the polygon when the chart is in interactive mode       |
| selectedColor           | Color   | #FFEFAC1D              | The color for the selected item when the chart is in interactive mode |

#### RadarEditWidget

| Name          | Type      | Default   | Description                                    |
|---------------|-----------|-----------|------------------------------------------------|
| showButtonBar | Boolean   | FALSE     | Whether to display the Save and Cancel buttons |
| textColor     | Color     | #FFFFFFFF | The color for the text                         |
| textSize      | Dimension | 32sp      | The size of the text                           |

## License

The source code for Android Radar Chart is released under the terms of the [MIT License](http://sguidetti.mit-license.org/).
