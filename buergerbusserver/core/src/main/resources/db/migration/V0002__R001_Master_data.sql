INSERT INTO bus(id, modificationCounter, numberPlate, color, picture,totalSeats, lineId, "TIMESTAMP") VALUES
                    (1, 0, 'KL-AB345', 'green', 'http://www.tm4.com/wp-content/uploads/2014/08/Foton-bus-12-m-e1407525133477.png', 10 ,1, '2004-10-19 10:23:54'),
                    (2, 0, 'KL-CD678', 'red', 'http://littlebabybum.com/wp-content/uploads/2015/01/wheels-on-the-bus-red.png', 12 ,2, '2004-10-19 10:23:54');


INSERT INTO line(id, modificationcounter, name, routeId, "TIMESTAMP")VALUES
				       (1, 0, 'Pirmasens', 1, '2004-10-19 10:23:54'),
					   (2, 0, 'Uni', 2, '2004-10-19 10:23:54');


INSERT INTO ROUTE(id, modificationcounter,route, "TIMESTAMP")
    VALUES (1,0,'7.608858346939087,49.210420445650286;7.60828,49.21046;7.60671,49.20822;7.60588,49.20856;7.60545,49.20888;7.60531,49.20907;7.60497,49.21059;7.60501,49.21081;7.60513,49.21102;7.60556,49.21091;7.60585,49.21077;7.60624,49.21077;7.60645,49.21066;7.60668,49.21075;7.60713,49.21072;7.60836,49.211;7.61012,49.21087;7.61018,49.21072;7.6104,49.21067;7.61052,49.21016;7.61022,49.20911;7.61,49.20862;7.60939,49.20767;7.60917,49.20738;7.60887,49.20711;7.60812,49.20673;7.60721,49.20636;7.60699,49.2066;7.6051,49.20639;7.60378,49.2069;7.60229,49.20766;7.60209,49.20764;7.59759,49.2135;7.59904,49.21387;7.59962,49.21374;7.59983,49.21361;7.60071,49.21245;','2004-10-19 10:23:54'),
            (2,0,'7.749749422073363,49.42727691523881;7.74945,49.42678;7.74935,49.42649;7.7493,49.42524;7.74939,49.42384;7.74937,49.42328;7.75349,49.42257;7.75408,49.42266;7.7543,49.42278;7.75445,49.42294;7.75498,49.42416;7.75516,49.42421;7.75625,49.42402;7.75693,49.42571;7.7569,49.42583;7.7568,49.42588;7.7543,49.4263;7.75413,49.42617;7.75381,49.42542;7.75363,49.42536;7.75054,49.42592;7.74932,49.4262;7.74835,49.42631;','2004-10-19 10:23:54');


--added by Hafiz
INSERT INTO LASTPOSITION(id,busId, modificationCounter, lon, lat, takenSeats, "TIMESTAMP") VALUES
                 (1,1,0, 7.60497,49.21059,2,'2004-10-19 10:23:54'),
                 (2,2,0, 7.75349,49.42257,7,'2004-10-19 10:23:54');


INSERT INTO STOP(id, modificationcounter,name, lon, lat, "TIMESTAMP")
          VALUES (1,0,'Kirche', 7.60747,49.209277,'2004-10-19 10:23:54'),
                 (2,0,'Brunnen', 7.606499,49.207937,'2004-10-20 10:23:54'),
                 (3,0,'Park', 7.604546,49.207636,'2004-10-19 10:23:54'),
                 (4,0,'Markt', 7.604975,49.209038,'2004-10-19 10:23:54'),
                 (5,0,'Uni West', 7.749317,49.424822,'2016-7-19 10:23:54'),
				 (6,0,'Uni Süd', 7.750694,49.423046,'2004-10-19 10:23:54'),
				 (7,0,'Uni Ost', 7.754991,49.423989,'2004-10-19 10:23:54'),
				 (8,0,'Uni Sporthalle', 7.750936,49.425893,'2004-10-19 10:23:54');

INSERT INTO line_stop( id, line_id, stop_id, "TIMESTAMP") VALUES
		     (1, 1, 1, '2004-10-19 10:23:54'),
		     (2, 1, 2, '2004-10-19 10:23:54'),
		     (3, 1, 3, '2004-10-19 10:23:54'),
		     (4, 1, 4, '2004-10-19 10:23:54'),
		     (5, 2, 5, '2004-10-19 10:23:54'),
			 (6, 2, 6, '2004-10-19 10:23:54'),
			 (7, 2, 7, '2004-10-19 10:23:54'),
			 (8, 2, 8, '2004-10-19 10:23:54');


-- Arriving Time = hours:min:sec
INSERT INTO schedule(
            id, modificationcounter, lineId, lineName , stopId, arrivingTime, "TIMESTAMP") values
----- stops for line 1
            (1, 0, 1, 'Pirmasens', 1, '09:00:00', '2004-10-19 10:23:54'),
            (2, 0, 1, 'Pirmasens', 1, '12:00:00', '2004-10-19 10:23:54'),
            (3, 0, 1, 'Pirmasens', 1, '13:00:00', '2004-10-19 10:23:54'),

            (4, 0, 1, 'Pirmasens', 2, '09:10:00', '2004-10-19 10:23:54'),
            (5, 0, 1, 'Pirmasens', 2, '12:10:00', '2004-10-19 10:23:54'),
            (6, 0, 1, 'Pirmasens', 2, '13:10:00', '2004-10-19 10:23:54'),

            (7, 0, 1, 'Pirmasens', 3, '09:20:00', '2004-10-19 10:23:54'),
            (8, 0, 1, 'Pirmasens', 3, '12:20:00', '2004-10-19 10:23:54'),
            (9, 0, 1, 'Pirmasens', 3, '13:20:00', '2004-10-19 10:23:54'),

			(10, 0, 1, 'Pirmasens', 4, '09:30:00', '2004-10-19 10:23:54'),
            (11, 0, 1, 'Pirmasens', 4, '12:30:00', '2004-10-19 10:23:54'),
            (12, 0, 1, 'Pirmasens', 4, '13:30:00', '2004-10-19 10:23:54'),

------------------- stops for the line2

            (13, 0, 2, 'Uni', 5, '09:00:00', '2004-10-19 10:23:54'),
            (14, 0, 2, 'Uni', 5, '12:00:00', '2004-10-19 10:23:54'),
            (15, 0, 2, 'Uni', 5, '13:00:00', '2004-10-19 10:23:54'),

            (16, 0, 2, 'Uni', 6, '09:10:00', '2004-10-19 10:23:54'),
            (17, 0, 2, 'Uni', 6, '12:10:00', '2004-10-19 10:23:54'),
            (18, 0, 2, 'Uni', 6, '13:10:00', '2004-10-19 10:23:54'),

			      (19, 0, 2, 'Uni', 7, '09:20:00', '2004-10-19 10:23:54'),
            (20, 0, 2, 'Uni', 7, '12:20:00', '2004-10-19 10:23:54'),
            (21, 0, 2, 'Uni', 7, '13:20:00', '2004-10-19 10:23:54'),

			      (22, 0, 2, 'Uni', 8, '09:30:00', '2004-10-19 10:23:54'),
            (23, 0, 2, 'Uni', 8, '12:30:00', '2004-10-19 10:23:54'),
            (24, 0, 2, 'Uni', 8, '13:30:00', '2004-10-19 10:23:54');


INSERT INTO CUSTOMSTOP(id, modificationCounter, lineId, pickUpTime, location, numberOfPersons, deviceId,
            userInfo, status, acceptingBus, rejectingBus, "TIMESTAMP") VALUES
            (1,0,1,GETDATE()+1, '7.60497, 49.21059', 3, '7', 'Schmidt;Brahmsweg 3, 67655 Kaiserslautern;1,2,5', 1, null, null, '2016-07-17 10:23:54');
