import 'package:diagnostico_diferencial/pages/checklistSintomas.dart';
import 'package:flutter/material.dart';
import 'package:expansion_card/expansion_card.dart';

class Resultado extends StatefulWidget {
  List resultado;
  Resultado(List resultado) {
    if (resultado == null)
      resultado = [
        [
          ["hjlbehaomowjdlbgunuelylcxrnauqzulxlgtwsre"],
          ["aturdimiento", "boca seca", "dolor de pecho"],
          ["alogia"]
        ],
        [
          ["flojmnugcpwgjxnylebtizhulvlrjetwlyrkzg"],
          ["aturdimiento", "dolor de abdomen"],
          ["alogia"]
        ],
        [
          ["qjbrnagyisjfkckr"],
          ["aturdimiento", "dolor de abdomen"],
          ["aturdimiento", "dolor de abdomen"]
        ]
      ];
    print("antes");
    print(resultado);
    for (int i = 0; i < resultado.length; i++) {
      for (int j = 0; j < 3; j++) {
        if (resultado[i][j] == null) resultado[i][j] = [""];
      }
    }
    this.resultado = resultado;
  }
  //Resultado(this.resultado);

  ResultadoState createState() {
    return new ResultadoState(resultado);
  }
}

class ResultadoState extends State<Resultado> {
  List resultado;
  int softBlue = 0xffE7F3FC;
  int mainBlue = 0xff048AEC;
  int mainRed = 0xffED201C;

  ResultadoState(this.resultado);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Color(softBlue),
        appBar: AppBar(
          title: Text("Resultado:"),
          centerTitle: true,
          elevation: 0,
          leading: IconButton(
            icon: Icon(Icons.arrow_back),
            onPressed: () => Navigator.pop(context, false),
          ),
        ),
        body: SingleChildScrollView(
            child: Column(
          children: resultado.map((enfermedad) {
            return ExpansionCard(
              initiallyExpanded: false,
              title: Container(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    Text(
                      enfermedad[0][0],
                      style: TextStyle(
                        color: Colors.black,
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                      ),//nombre de la enfermedad
                    ),
                  ],
                ),
              ),
              children: <Widget>[
                Container(
                  //para signos
                  margin: EdgeInsets.symmetric(horizontal: 7),
                  child: Column(
                    children:
                        enfermedad[1].map<Widget>((sintoma) {
                          if(sintoma==enfermedad[1][0]){
                            return Column(
                              children: [
                                Text(
                                  "Sintomas",
                                  style: TextStyle(
                                    color: Color(mainBlue),
                                    fontWeight: FontWeight.bold,
                                    fontSize: 20,
                                  ),
                                ),
                                Text(
                                  sintoma,
                                  style: TextStyle(
                                    color: Colors.blueAccent,
                                    fontSize: 15,
                                  ),
                                )
                              ],
                            );
                          }
                          else{
                            return Text(
                              sintoma,
                              style: TextStyle(
                                color: Colors.blueAccent,
                                fontSize: 15,
                              ),
                            );
                          }

                        }).toList(),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Container(
                  //para signos
                  margin: EdgeInsets.symmetric(horizontal: 7),
                  child: Column(
                    children:
                        enfermedad[2].map<Widget>((signo) {
                          if(signo==enfermedad[2][0]){
                            return Column(
                              children: [
                                  Text(
                                    "Signos",
                                    style: TextStyle(
                                      color: Color(mainBlue),
                                      fontWeight: FontWeight.bold,
                                      fontSize: 20,
                                    ),
                                  ),
                                  Text(
                                    signo,
                                    style: TextStyle(
                                      color: Colors.blueAccent,
                                      fontSize: 15,
                                    ),
                                  )
                              ],
                            );
                          }
                          return Text(
                            signo,
                            style: TextStyle(
                              color: Colors.blueAccent,
                              fontSize: 15,
                            ),
                          );
                        }).toList(),
                  ),
                ),
              ],
            );
          }).toList(),
        )),
      ),
    );
  }
}
