import 'package:flutter/material.dart';

class Sidebar extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: 250,
      color: Color(0xFF121212),

      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          SizedBox(height: 20),

          Padding(
            padding: const EdgeInsets.all(10),
            child: Text(
              "Tu biblioteca",
              style: TextStyle(color: Colors.white, fontSize: 18),
            ),
          ),

          Padding(
            padding: const EdgeInsets.all(10),
            child: ElevatedButton(
              onPressed: () {},
              child: Text("Crear playlist"),
            ),
          ),
        ],
      ),
    );
  }
}