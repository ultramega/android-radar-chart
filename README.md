# Android Radar Chart

This library provides a View that renders a radar chart and a widget for editing the values in the chart.

## Classes

### RadarView

Custom View to render a simple radar graph with configurable values, labels, and scale. Also supports editing method calls. Can be rotated with animation.

#### XML Attributes

| Name                    | Type    | Default                | Description                                                           |
|-------------------------|---------|------------------------|-----------------------------------------------------------------------|
| circleColor             | Color   | #FFCCCCCC              | The color for the circles                                             |
| gravity                 | Gravity | center_horizontal\|top | The alignment of the View within its container                        |
| labelColor              | Color   | #FFFFFFFF              | The color for the label text                                          |
| polygonColor            | Color   | #DD0066FF              | The color for the polygon representing the data in the chart          |
| polygonColorInteractive | Color   | #DDFF66FF              | The color for the polygon when the chart is in interactive mode       |
| selectedColor           | Color   | #FFEFAC1D              | The color for the selected item when the chart is in interactive mode |

#### Public Methods

##### addRadarViewListener

`void addRadarViewListener (RadarView.RadarViewListener listener)`

Add a `RadarViewListener` to this `RadarView`.

**Parameters:**

| Name     | Description           |
|----------|-----------------------|
| listener | A `RadarViewListener` |

##### getCircleColor

`int getCircleColor ()`

Get the color used for the circles.

**Returns:** The color hex value

##### getData

`ArrayList<RadarHolder> getData ()`

Get the data currently being rendered in this chart.

**Returns:** An array of data points contained in `RadarHolder`s

##### getGravity

`int getGravity ()`

Get the current Gravity flags.

**Returns:** The current Gravity flags

##### getLabelColor

`int getLabelColor ()`

Get the color used for the labels.

**Returns:** The color hex value

##### getMaxValue

`int getMaxValue ()`

Get the maximum value any data point can have.

**Returns:** The maximum value

##### getPolygonColor

`int getPolygonColor ()`

Get the color used for the polygon.

**Returns:** The color hex value

##### getPolygonInteractiveColor

`int getPolygonInteractiveColor ()`

Get the color used for the polygon while in interactive mode.

**Returns:** The color hex value

##### getSelectedColor

`int getSelectedColor ()`

Get the color used for the selected item.

**Returns:** The color hex value

##### getSelectedIndex

`int getSelectedIndex ()`

Get the index of the currently selected data point.

**Returns:** The array index of the selected data point

##### getSelectedName

`String getSelectedName ()`

Get the label for the currently selected data point.

**Returns:** The name field of the selected data point

##### getSelectedValue

`int getSelectedValue ()`

Get the value of the currently selected data point.

**Returns:** The value of the selected data point

##### hasData

`boolean hasData ()`

Does this chart have any data?

**Returns:** Whether the chart has data

##### isInteractive

`boolean isInteractive ()`

Is the chart in interactive mode?

**Returns:** Whether the chart is interactive

##### removeRadarViewListener

`void removeRadarViewListener (RadarView.RadarViewListener listener)`

Remove a `RadarViewListener` from this `RadarView`.

**Parameters:**

| Name     | Description           |
|----------|-----------------------|
| listener | A `RadarViewListener` |

##### setCircleColor

`void setCircleColor (int color)`

Set the color used for the circles.

**Parameters:**

| Name  | Description         |
|-------|---------------------|
| color | The color hex value |

##### setData

`void setData (ArrayList<RadarHolder> data)`

Set the data to render in this chart.

**Parameters:**

| Name | Description                                       |
|------|---------------------------------------------------|
| data | An array of data points contained in RadarHolders |

##### setGravity

`void setGravity (int gravity)`

Set the Gravity flags for the view.

**Parameters:**

| Name    | Description                   |
|---------|-------------------------------|
| gravity | One or more Gravity constants |

##### setInteractive

`void setInteractive (boolean interactive)`

Enable or disable interactive mode. The chart must have data to enable interactive mode.

**Parameters:**

| Name        | Description                        |
|-------------|------------------------------------|
| interactive | Whether to enable interactive mode |

##### setLabelColor

`void setLabelColor (int color)`

Set the color used for the labels.

**Parameters:**

| Name  | Description         |
|-------|---------------------|
| color | The color hex value |

##### setMaxValue

`void setMaxValue (int maxValue)`

Set the maximum value any data point can have.

**Parameters:**

| Name     | Description       |
|----------|-------------------|
| maxValue | The maximum value |

##### setPolygonColor

`void setPolygonColor (int color)`

Set the color used for the polygon.

**Parameters:**

| Name  | Description         |
|-------|---------------------|
| color | The color hex value |

##### setPolygonInteractiveColor

`void setPolygonInteractiveColor (int color)`

Set the color used for the polygon while in interactive mode.

**Parameters:**

| Name  | Description         |
|-------|---------------------|
| color | The color hex value |

##### setSelectedColor

`void setSelectedColor (int color)`

Set the color used for the selected item.

**Parameters:**

| Name  | Description         |
|-------|---------------------|
| color | The color hex value |

##### setSelectedValue

`void setSelectedValue (int value)`

Set the value of the currently selected data point.

**Parameters:**

| Name  | Description |
|-------|-------------|
| value | The value   |

##### turnCCW

`void turnCCW ()`

Turn the chart counter-clockwise.

##### turnCW

`void turnCW ()`

Turn the chart clockwise.

##### turnTo

`void turnTo (int key)`

Turn the chart to a specific data point.

**Parameters:**

| Name | Description               |
|------|---------------------------|
| key  | The data point to turn to |

### RadarEditWidget

A widget for interacting with a `RadarView`.

#### XML Attributes

| Name          | Type      | Default   | Description                                    |
|---------------|-----------|-----------|------------------------------------------------|
| showButtonBar | Boolean   | FALSE     | Whether to display the Save and Cancel buttons |
| textColor     | Color     | #FFFFFFFF | The color for the text                         |
| textSize      | Dimension | 32sp      | The size of the text                           |

#### Public Methods

##### getShowButtonBar

`boolean getShowButtonBar ()`

**Returns:** Whether the button bar is showing

Get the current status of the button bar.

##### setOnButtonClickListener

`void setOnButtonClickListener (RadarEditWidget.OnButtonClickListener listener)`

Set the listener for button clicks.

**Parameters:**

| Name     | Description                       |
|----------|-----------------------------------|
| listener | An `OnButtonClickListener` object |

##### setShowButtonBar

`void setShowButtonBar (boolean showButtonBar)`

Show or hide the button bar.

**Parameters:**

| Name          | Description                       |
|---------------|-----------------------------------|
| showButtonBar | Whether to display the button bar |

##### setTarget

`void setTarget (RadarView radarView)`

Set the target `RadarView` to interact with.

**Parameters:**

| Name      | Description                    |
|-----------|--------------------------------|
| radarView | A `RadarView` to interact with |

### RadarHolder

Holds the data associated with a data point on a `RadarView`.

#### Constructors

##### RadarHolder

`RadarHolder (String name, int value)`

**Parameters:**

| Name  | Description                               |
|-------|-------------------------------------------|
| name  | The name of this item to use as the label |
| value | The value of this data point              |

#### Public Properties

##### name

`final String name`

The label for this item

##### value

`int value`

The value of this item

## Interfaces

### RadarView.RadarViewListener

Interface for objects to listen for changes to `RadarView`s.

#### Public Methods

##### onDataChanged

`void onDataChanged (ArrayList<RadarHolder> newData)`

Called when the data is changed.

**Parameters:**

| Name    | Description  |
|---------|--------------|
| newData | The new data |

##### onInteractiveModeChanged

`void onInteractiveModeChanged (boolean interactive)`

Called when the interactive status is changed.

**Parameters:**

| Name        | Description                            |
|-------------|----------------------------------------|
| interactive | Whether the `RadarView` is interactive |

##### onMaxValueChanged

`void onMaxValueChanged (int maxValue)`

Called when the maximum item value is changed.

**Parameters:**

| Name     | Description           |
|----------|-----------------------|
| maxValue | The new maximum value |

##### onSelectedItemChanged

`void onSelectedItemChanged (int index, String name, int value)`

Called when the selected item index is changed.

**Parameters:**

| Name  | Description                    |
|-------|--------------------------------|
| index | The index of the selected item |
| name  | The name of the selected item  |
| value | The value of the selected item |

##### onSelectedValueChanged

`void onSelectedValueChanged (int newValue)`

Called when the value of the selected item is changed.

**Parameters:**

| Name     | Description                        |
|----------|------------------------------------|
| newValue | The new value of the selected item |

### RadarEditWidget.OnButtonClickListener

Interface for listeners for button bar clicks.

#### Public Methods

##### onCancel

`void onCancel ()`

Called when the cancel button is clicked.

##### onSave

`void onSave ()`

Called when the save button is clicked.

## License

The source code for Android Radar Chart is released under the terms of the [MIT License](http://sguidetti.mit-license.org/).
