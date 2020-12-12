import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:diagnostico_diferencial/pages/homePage.dart';
import 'package:diagnostico_diferencial/pages/checklistSignos.dart';
import 'package:diagnostico_diferencial/pages/checklistSintomas.dart';
import 'package:diagnostico_diferencial/pages/resultadoDiagnostico.dart';
import 'package:diagnostico_diferencial/pages/Registros.dart';
import 'package:diagnostico_diferencial/pages/MyModel.dart';
import 'package:provider/provider.dart';

void main() => runApp(ChangeNotifierProvider(
      builder: (context) => AppState(),
      child: MaterialApp(initialRoute: '/', routes: {
        "/": (context) => Home(),
        '/signos': (context) => Signos(),
        '/sintomas': (context) => Sintomas(),
        //'/resultado' :(context) => Resultado(),
      }),
    ));
