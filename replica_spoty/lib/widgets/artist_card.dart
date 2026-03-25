import 'package:flutter/material.dart';

class ArtistCard extends StatelessWidget {
  final String name;

  ArtistCard({required this.name});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 120,
      margin: EdgeInsets.only(right: 10),

      child: Column(
        children: [
          CircleAvatar(
            radius: 40,
            backgroundColor: Colors.grey,
          ),
          SizedBox(height: 10),
          Text(name, style: TextStyle(color: Colors.white))
        ],
      ),
    );
  }
}