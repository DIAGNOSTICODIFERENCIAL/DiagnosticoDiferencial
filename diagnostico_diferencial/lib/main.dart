import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget{

  int mainBlue = 0xff048AEC;
  int mainRed = 0xffED201C;
  int softBlue = 0xffE7F3FC;

  Widget build(BuildContext context){
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text(""),
        ),
        backgroundColor: Color(softBlue),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Container(
              alignment: Alignment.center,
              child:Text(
                "DIAGNÓSTICO DIFERENCIAL",
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                  color: Color(mainBlue),
                  height: 5,
                ),
              ),
            ),
            Container(
              margin: EdgeInsets.fromLTRB(0, 150, 0, 0),
              child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: <Widget>[
                    Container(
                      child: RaisedButton(
                        onPressed: (){},
                        child:Text(
                          "SÍNTOMAS",
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        color: Color(mainBlue),
                      ),
                    ),
                    Container(
                      child: RaisedButton(
                        onPressed: (){},
                        child:Text(
                          "SIGNOS",
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        color: Color(mainBlue),
                      ),
                    ),
                    Container(
                      child: RaisedButton(
                        onPressed: (){},
                        child:Text(
                          "DIAGNÓSTICO",
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            color: Colors.white,
                          ),
                        ),
                        color: Color(mainRed),
                      ),
                    ),
                  ],
              ),
            ),

          ],
        )
      ),
    );
  }
}