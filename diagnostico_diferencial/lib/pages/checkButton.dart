import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'MyModel.dart';


class CustomImageCheckbox extends StatefulWidget {

  String label;
  bool isChecked;
  String type;
  CustomImageCheckbox(String label,bool isChecked,String type){
    this.label = label;
    this.isChecked = isChecked;
    this.type = type;
  }

  CustomImageCheckboxState createState() {
    return new CustomImageCheckboxState(label,isChecked,type);
  }

}

class CustomImageCheckboxState extends State<CustomImageCheckbox> {
  bool _isChecked = false;
  String label = "";
  String type = "";
  @override


  CustomImageCheckboxState(this.label,this._isChecked,this.type);

  Widget build(BuildContext context) {
    final appState = Provider.of<AppState>(context);
    return Container(
      child:CheckboxListTile(
        value :_isChecked,
        title: Text(label),
        onChanged: (bool newValue) {
          setState(() {
            _isChecked = newValue;
            if(type=="sintoma"){
              appState.addSintoma(label);
            }
            else{
              appState.addSigno(label);
            }
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