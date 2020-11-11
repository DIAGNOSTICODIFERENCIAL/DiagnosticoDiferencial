import 'package:flutter/material.dart';


class CustomImageCheckbox extends StatefulWidget {

  String label;
  CustomImageCheckbox(String label){
    this.label = label;
  }

  CustomImageCheckboxState createState() {
    return new CustomImageCheckboxState(label);
  }

}

class CustomImageCheckboxState extends State<CustomImageCheckbox> {
  bool _isChecked = false;
  String label = "";
  @override


  CustomImageCheckboxState(this.label);

  Widget build(BuildContext context) {
    return Container(
      child:CheckboxListTile(
        value :_isChecked,
        title: Text(label),
        onChanged: (bool newValue) {
          setState(() {
            _isChecked = newValue;
          });
        },
      ),
      );
  }
  void estado(String dato){
    setState(() {
      label = dato;
    });
  }
}