  import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter/widgets.dart';

class AppState with ChangeNotifier{

  Set<String> _signos = {};
  Set<String> _sintomas = {};
  Set<String> _todosExp = {};


  get todos{
    return _todosExp.toList();
  }
  get signos{
    return _signos.toList();
  }
  get sintomas{
    return _sintomas.toList();
  }

  void addTodos(String dato){
    _todosExp.add(dato);
    notifyListeners();
  }
  void addSigno(String signo){
    _signos.add(signo);
    notifyListeners();
  }
  void addSintoma(String sintoma){
    _sintomas.add(sintoma);
    notifyListeners();
  }



}