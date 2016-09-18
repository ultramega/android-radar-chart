# Android Radar Chart

This library provides a View that renders a radar chart and a widget for editing the values in the chart.

## Installation

Add the dependency to your module's **build.gradle** file:

```gradle
dependencies {
    compile 'com.ultramegasoft.radarchart:radar-chart:0.1.2'
}
```

## Usage

For a full example, see the example application in the **testapp** module. Below is a quick setup guide.

### RadarView

   1. Add the View to the layout:

```xml
<com.ultramegasoft.radarchart.RadarView
    android:id="@+id/radar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_centerHorizontal="true" />
```

   2. Load the View from the layout:

```java
mRadarView = (RadarView)findViewById(R.id.radar);
```

   3. Set the data for the RadarView to display as an `ArrayList` of `RadarHolder` objects:

```java
mRadarView.setData(mData);
```

   4. Enable or disable interactive mode:

```java
mRadarView.setInteractive(true);
mRadarView.setInteractive(false);
```

### RadarEditWidget

   1. Add the app namespace to the root element of your layout if it is not already added:

```xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```

   2. Add the View to the layout:

```xml
<com.ultramegasoft.radarchart.RadarEditWidget
    android:id="@+id/edit_widget"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_alignParentBottom="true"
    app:showButtonBar="true" />
```

   3. Load the View from the layout:

```java
mEditWidget = (RadarEditWidget)findViewById(R.id.edit_widget);
```

   4. Set the target `RadarView` for the `RadarEditWidget` to control:

```java
mEditWidget.setTarget(mRadarView);
```

   5. If you enabled the button bar, set the callbacks for the buttons:

```java
mEditWidget.setOnButtonClickListener(new RadarEditWidget.OnButtonClickListener() {
    @Override
    public void onSave() {
        // Save button clicked
    }
    
    @Override
    public void onCancel() {
        // Cancel button clicked
    }
});
```

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

##### Gravity Options

Options available for the `gravity` XML attribute. Multiple options can be combined by separating them with the `|` character.

| Constant          | Description                                                                              |
|-------------------|------------------------------------------------------------------------------------------|
| top               | Push object to the top of its container                                                  |
| bottom            | Push object to the bottom of its container                                               |
| left              | Push object to the left of its container                                                 |
| right             | Push object to the right of its container                                                |
| center_vertical   | Place object in the vertical center of its container                                     |
| center_horizontal | Place object in the horizontal center of its container                                   |
| center            | Place the object in the center of its container in both the vertical and horizontal axis |
| start             | Push object to the beginning of its container                                            |
| end               | Push object to the end of its container                                                  | 

#### RadarEditWidget

| Name          | Type      | Default   | Description                                    |
|---------------|-----------|-----------|------------------------------------------------|
| showButtonBar | Boolean   | FALSE     | Whether to display the Save and Cancel buttons |
| textColor     | Color     | #FFFFFFFF | The color for the text                         |
| textSize      | Dimension | 32sp      | The size of the text                           |

## License

The source code for Android Radar Chart is released under the terms of the [MIT License](http://sguidetti.mit-license.org/).
