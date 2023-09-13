
insert into admin (id, email, password_hash, name) values (1, 'Max@mail.ru', '12345', 'Admin_1');
insert into admin (id, email, password_hash, name) values (2, 'Alina@mail.ru', '13312442', 'Admin_2');
insert into admin (id, email, password_hash, name) values (3, 'Sabina@mail.ru', '1516252', 'Admin_3');

insert into country (id, name, admin_id) values (1, 'Indonesia', 1);
insert into country (id, name, admin_id) values (2, 'Kuwait', 1);
insert into country (id, name, admin_id) values (3, 'Malta', 1);
insert into country (id, name, admin_id) values (4, 'Albania', 1);
insert into country (id, name, admin_id) values (5, 'Brazil', 1);
insert into country (id, name, admin_id) values (6, 'Djibouti', 1);
insert into country (id, name, admin_id) values (7, 'Portugal', 1);
insert into country (id, name, admin_id) values (8, 'France', 1);
insert into country (id, name, admin_id) values (9, 'American Samoa', 1);
insert into country (id, name, admin_id) values (10, 'Sri Lanka', 2);
insert into country (id, name, admin_id) values (11, 'Guatemala', 2);
insert into country (id, name, admin_id) values (12, 'Egypt', 2);
insert into country (id, name, admin_id) values (13, 'Japan', 2);
insert into country (id, name, admin_id) values (14, 'Georgia', 2);
insert into country (id, name, admin_id) values (15, 'Madagascar', 2);
insert into country (id, name, admin_id) values (16, 'Spain', 2);
insert into country (id, name, admin_id) values (17, 'Greece', 2);
insert into country (id, name, admin_id) values (18, 'Tanzania', 2);
insert into country (id, name, admin_id) values (19, 'Greenland', 2);
insert into country (id, name, admin_id) values (20, 'Barbados', 2);
insert into country (id, name, admin_id) values (21, 'Angola', 3);
insert into country (id, name, admin_id) values (22, 'Jamaica', 3);
insert into country (id, name, admin_id) values (23, 'Columbia', 3);
insert into country (id, name, admin_id) values (24, 'Peru', 3);
insert into country (id, name, admin_id) values (25, 'Saint Lucia', 3);
insert into country (id, name, admin_id) values (26, 'Honduras', 3);
insert into country (id, name, admin_id) values (27, 'Bouvet Island', 3);
insert into country (id, name, admin_id) values (28, 'Myanmar', 3);
insert into country (id, name, admin_id) values (29, 'Tuvalu', 3);
insert into country (id, name, admin_id) values (30, 'Gabon', 3);

insert into hotel (id, name, stars, features, admin_id) values (1, 'Kautzer, D''Amore and Schneider', 2, 'WITH_WIFI', 1);
insert into hotel (id, name, stars, features, admin_id) values (2, 'Morar-Goyette', 2, 'WITHOUT_WIFI', 1);
insert into hotel (id, name, stars, features, admin_id) values (3, 'Borer and Sons', 4, 'WITH_MINI_BAR', 1);
insert into hotel (id, name, stars, features, admin_id) values (4, 'Maggio-Stoltenberg', 3, 'LOW_COST', 1);
insert into hotel (id, name, stars, features, admin_id) values (5, 'KJohnson-Luettgen', 2, 'HAS_A_PRESIDENT_ROOM', 1);
insert into hotel (id, name, stars, features, admin_id) values (6, 'Green-Kertzmann', 1, 'WITH_WIFI', 1);
insert into hotel (id, name, stars, features, admin_id) values (7, 'Wuckert, Frami and Jast', 1, 'WITH_SWIMMING_POOL', 1);
insert into hotel (id, name, stars, features, admin_id) values (8, 'Berge, Hirthe and Kihn', 2, 'ALL_INCLUSIVE', 1);
insert into hotel (id, name, stars, features, admin_id) values (9, 'Swaniawski-Emard', 1, 'LOW_COST', 1);
insert into hotel (id, name, stars, features, admin_id) values (10, 'Rice-Daugherty', 1, 'WITH_MINI_BAR', 2);
insert into hotel (id, name, stars, features, admin_id) values (11, 'Rolfson, Bergnaum and Glover', 1, 'HAS_A_PRESIDENT_ROOM', 2);
insert into hotel (id, name, stars, features, admin_id) values (12, 'KWill and Sons', 3, 'WITH_WIFI', 2);
insert into hotel (id, name, stars, features, admin_id) values (13, 'Ruecker and Sons', 4, 'WITH_CINEMA', 2);
insert into hotel (id, name, stars, features, admin_id) values (14, 'Marks, Satterfield and VonRueden', 3, 'NEAR_THE_BEACH', 2);
insert into hotel (id, name, stars, features, admin_id) values (15, 'Padberg-Ziemann', 5, 'WITH_PARKING', 2);
insert into hotel (id, name, stars, features, admin_id) values (16, 'Altenwerth-Blanda', 3, 'ALL_INCLUSIVE', 2);
insert into hotel (id, name, stars, features, admin_id) values (17, 'Armstrong and Sons', 4, 'WITH_SWIMMING_POOL', 2);
insert into hotel (id, name, stars, features, admin_id) values (18, 'Lang Inc', 3, 'WITH_PARKING', 2);
insert into hotel (id, name, stars, features, admin_id) values (19, 'Ebert Group', 3, 'NEAR_THE_BEACH', 3);
insert into hotel (id, name, stars, features, admin_id) values (20, 'Durgan, Carroll and Braun', 3, 'WITH_MINI_BAR', 3);
insert into hotel (id, name, stars, features, admin_id) values (21, 'Hagenes LLC', 3, 'WITHOUT_WIFI', 3);
insert into hotel (id, name, stars, features, admin_id) values (22, 'Beatty and Sons', 1, 'NEAR_THE_BEACH', 3);
insert into hotel (id, name, stars, features, admin_id) values (23, 'Thompson Inc', 4, 'WITH_MINI_BAR', 3);
insert into hotel (id, name, stars, features, admin_id) values (24, 'Abbott, Dibbert and Koss', 4, 'WITH_MINI_BAR', 3);
insert into hotel (id, name, stars, features, admin_id) values (25, 'Mosciski Inc', 2, 'WITH_PARKING', 3);
insert into hotel (id, name, stars, features, admin_id) values (26, 'McKenzie Group', 5, 'LOW_COST', 3);
insert into hotel (id, name, stars, features, admin_id) values (27, 'Dibbert, Doyle and Ortiz', 2, 'WITHOUT_WIFI', 3);
insert into hotel (id, name, stars, features, admin_id) values (28, 'Blanda, Pollich and Legros', 5, 'WITH_MINI_BAR', 3);
insert into hotel (id, name, stars, features, admin_id) values (29,'McDermott, Wolff and Pfannerstill', 4, 'WITHOUT_WIFI', 3);
insert into hotel (id, name, stars, features, admin_id) values (30, 'Skiles, Rohan and Hirthe', 3, 'LOW_COST', 3);

insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (1, '2023-12-09', 27, 'Extirpation of Matter from Thalamus, Percutaneous Approach', 715, 'CHILD_TOUR', 1, 1, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (2, '2022-09-30', 5, 'Release Sternum, Percutaneous Approach',  600, 'SHOPPING_TOUR', 2, 2, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (3, '2024-02-26', 25, 'Revision of Nonautologous Tissue Substitute in Vagina and Cul-de-sac, Percutaneous Endoscopic Approach', 420, 'FAMILY_TOUR', 3, 3, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (4, '2022-01-08', 20, 'Reposition Left Tibia, External Approach', 545, 'WEEDING_TOUR', 4, 4, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (5, '2024-04-26', 29, 'Supplement Right Lower Extremity Lymphatic with Nonautologous Tissue Substitute, Open Approach', 353, 'SIGHTSEEING_TOUR', 5, 5, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (6, '2022-04-27', 8, 'Insertion of Infusion Device into Thoracolumbar Vertebral Joint, Percutaneous Approach', 303, 'SIGHTSEEING_TOUR', 6, 6, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (7, '2024-03-05', 29, 'Magnetic Resonance Imaging (MRI) of Abdomen using Other Contrast, Unenhanced and Enhanced', 697, 'FAMILY_TOUR', 7, 7, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (8, '2022-04-06', 22, 'Extirpation of Matter from Left External Carotid Artery, Open Approach', 483, 'FAMILY_TOUR', 8, 8, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (9, '2023-12-27', 23, 'Restriction of Jejunum, Via Natural or Artificial Opening Endoscopic', 909, 'SIGHTSEEING_TOUR', 9, 9, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (10, '2022-11-28', 15, 'Restriction of Left Posterior Tibial Artery with Intraluminal Device, Open Approach', 597, 'HEALTH_TOUR', 10, 10, 1);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (11, '2023-12-23', 24, 'Excision of Left Axilla, Percutaneous Endoscopic Approach', 743, 'WEEKEND_TOUR', 11, 11, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (12, '2022-10-10', 30, 'Supplement Left Thumb with Synthetic Substitute, Percutaneous Endoscopic Approach', 635, 'HEALTH_TOUR', 12, 12, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (13, '2024-01-06', 21, 'Revision of Infusion Device in Thoracic Duct, Percutaneous Endoscopic Approach', 627, 'CHILD_TOUR', 13, 13, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (14, '2022-03-03', 3, 'Revision of Intraluminal Device in Pancreatic Duct, Via Natural or Artificial Opening Endoscopic', 512, 'WEEKEND_TOUR', 14, 14, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (15, '2023-11-12', 20, 'Inspection of Pituitary Gland, Open Approach', 616, 'FAMILY_TOUR', 15, 15, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (16, '2022-11-24', 12, 'Alteration of Left Upper Arm Subcutaneous Tissue and Fascia, Percutaneous Approach', 549, 'SIGHTSEEING_TOUR', 16, 16, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (17, '2024-04-06', 13, 'Drainage of Right Lower Lung Lobe with Drainage Device, Via Natural or Artificial Opening Endoscopic', 512, 'FAMILY_TOUR', 17, 17, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (18, '2022-02-10', 11, 'Revision of Autologous Tissue Substitute in Face, External Approach', 853, 'BUS_TOUR', 18, 18, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (19, '2023-12-29', 16, 'Dilation of Gastric Artery, Bifurcation, with Two Intraluminal Devices, Percutaneous Endoscopic Approach', 541, 'WEEKEND_TOUR', 19, 19, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (20, '2022-12-12', 21, 'Removal of Nonautologous Tissue Substitute from Fallopian Tube, Via Natural or Artificial Opening', 725, 'WEEDING_TOUR', 20, 20, 2);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (21, '2023-11-21', 19, 'Release Splenic Artery, Percutaneous Approach', 320, 'HEALTH_TOUR', 21, 21, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (22, '2022-10-21', 6, 'Destruction of Left Hip Joint, Percutaneous Endoscopic Approach', 668, 'CHILD_TOUR', 22, 22, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (23, '2024-01-11', 15, 'Magnetic Resonance Imaging (MRI) of Bilateral Submandibular Glands using Other Contrast', 836, 'WEEKEND_TOUR', 23, 23, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (24, '2022-12-13', 28, 'Supplement Left Elbow Joint with Synthetic Substitute, Percutaneous Approach', 881, 'WEEDING_TOUR', 24, 24, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (25, '2024-04-11', 15, 'Dilation of Right Temporal Artery, Bifurcation, with Three Drug-eluting Intraluminal Devices, Percutaneous Endoscopic Approach', 583, 'EVENT_TOUR', 25, 25, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (26, '2022-04-07', 14, 'Release Multiple Parathyroid Glands, Open Approach', 664, 'WEEKEND_TOUR', 26, 26, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (27, '2022-04-11', 24, 'Revision of Extraluminal Device in Hepatobiliary Duct, Percutaneous Endoscopic Approach', 785, 'FAMILY_TOUR', 27, 27, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (28, '2023-12-29', 21, 'Destruction of Bilateral Vas Deferens, Percutaneous Approach', 393, 'SIGHTSEEING_TOUR', 28, 28, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (29, '2023-03-16', 30, 'Excision of Sigmoid Colon, Via Natural or Artificial Opening Endoscopic', 489, 'SHOPPING_TOUR', 29, 29, 3);
insert into tour (id, date, duration, description, cost, tour_type, hotel_id, country_id, admin_id) values (30, '2022-11-14', 27, 'Excision of Right Ovary, Percutaneous Endoscopic Approach, Diagnostic', 971, 'SAFARI', 30, 30, 3);

insert into client (id, email, password_hash, first_name, last_name) values (1, 'lsunock0@over-blog.com', 'dD7*{v', 'Lezley', 'Sunock');
insert into client (id, email, password_hash, first_name, last_name) values (2, 'corchard1@livejournal.com', 'iQ5@EUv', 'Cathee', 'Orchard');
insert into client (id, email, password_hash, first_name, last_name) values (3, 'htwiddy2@t-online.de', 'oZ9,RGB', 'Hillie', 'Twiddy');
insert into client (id, email, password_hash, first_name, last_name) values (4, 'fkonzelmann3@furl.net', 'uW6/\Y~)LU', 'Franni', 'Konzelmann');
insert into client (id, email, password_hash, first_name, last_name) values (5, 'mwoodson4@feedburner.com', 'lS3=YpX', 'Murvyn', 'Woodson');
insert into client (id, email, password_hash, first_name, last_name) values (6, 'adornan5@odnoklassniki.ru', 'pS6_}{<', 'Abagael', 'Dornan');
insert into client (id, email, password_hash, first_name, last_name) values (7, 'lcundey6@purevolume.com', 'iK2%{|8', 'Levin', 'Cundey');
insert into client (id, email, password_hash, first_name, last_name) values (8, 'agreenhouse7@woothemes.com', 'cI3<(', 'Alexandre', 'Greenhouse');
insert into client (id, email, password_hash, first_name, last_name) values (9, 'sdowty8@ibm.com', 'yT4!M\TT', 'Sascha', 'Dowty');
insert into client (id, email, password_hash, first_name, last_name) values (10, 'bfillery9@vimeo.com', 'hD2>nb1Il%', 'Brooks', 'Fillery');
insert into client (id, email, password_hash, first_name, last_name) values (11, 'bcrammya@odnoklassniki.ru', 'hO7""v_', 'Birdie', 'Crammy');
insert into client (id, email, password_hash, first_name, last_name) values (12, 'criceb@hhs.gov', 'dL3`5!v', 'Cristina', 'Rice');
insert into client (id, email, password_hash, first_name, last_name) values (13, 'skarolewskic@digg.com', 'fI0!#rC', 'Shurwood', 'Karolewski');
insert into client (id, email, password_hash, first_name, last_name) values (14, 'jingyond@ameblo.jp', 'qO4\,gQaw<', 'Jourdan', 'Ingyon');
insert into client (id, email, password_hash, first_name, last_name) values (15, 'nsneezeme@arizona.edu', 'sQ5*DRn', 'Nerte', 'Sneezem');
insert into client (id, email, password_hash, first_name, last_name) values (16, 'ydemangeonf@earthlink.net', 'gW3$w0FC<f', 'Yelena', 'Demangeon');
insert into client (id, email, password_hash, first_name, last_name) values (17, 'istreetsg@uiuc.edu', 'mK5/m', 'Ilene', 'Streets');
insert into client (id, email, password_hash, first_name, last_name) values (18, 'ezinkh@disqus.com', 'tX7%B?', 'Everard', 'Zink');
insert into client (id, email, password_hash, first_name, last_name) values (19, 'rpaynesi@slashdot.org', 'fO2%PB', 'Reine', 'Paynes');
insert into client (id, email, password_hash, first_name, last_name) values (20, 'idunkirkj@usa.gov', 'fY4(g+=p+', 'Ingar', 'Dunkirk');
insert into client (id, email, password_hash, first_name, last_name) values (21, 'dtallonk@amazon.com', 'yT5$A{fg', 'Dulciana', 'Tallon');
insert into client (id, email, password_hash, first_name, last_name) values (22, 'jdwerryhousel@vistaprint.com', 'zI7@o9V}C', 'Jeremie', 'Dwerryhouse');
insert into client (id, email, password_hash, first_name, last_name) values (23, 'tbasezzim@amazon.co.jp', 'pO8{<', 'Terrill', 'Basezzi');
insert into client (id, email, password_hash, first_name, last_name) values (24, 'htrasen@google.co.jp', 'eV4=>oN', 'Hy', 'Trase');
insert into client (id, email, password_hash, first_name, last_name) values (25, 'lleynhamo@sbwire.com', 'cK2{2,wBX', 'Loralyn', 'Leynham');
insert into client (id, email, password_hash, first_name, last_name) values (26, 'aaynscombep@bluehost.com', 'fZ7+8', 'Aubry', 'Aynscombe');
insert into client (id, email, password_hash, first_name, last_name) values (27, 'dmarquetq@icio.us', 'vK7_KK', 'Dana', 'Marquet');
insert into client (id, email, password_hash, first_name, last_name) values (28, 'fjannaschr@vk.com', 'cW3/R', 'Felicdad', 'Jannasch');
insert into client (id, email, password_hash, first_name, last_name) values (29, 'ckayss@psu.edu', 'eV3+B=8K', 'Costa', 'Kays');
insert into client (id, email, password_hash, first_name, last_name) values (30, 'zrogiert@ezinearticles.com', 'bY1~PPL.{d', 'Zolly', 'Rogier');

insert into review (id, content, created_at, client_id, tour_id) values (1, 'So expensive', '2023-04-20 13:57:25', 1, 2);
insert into review (id, content, created_at, client_id, tour_id) values (2, 'Great memoirs', '2022-09-26 22:45:16', 2, 4);
insert into review (id, content, created_at, client_id, tour_id) values (3, 'Great memoirs', '2023-08-21 01:47:59', 3, 6);
insert into review (id, content, created_at, client_id, tour_id) values (4, 'Great memoirs', '2022-09-26 05:04:37', 4, 8);
insert into review (id, content, created_at, client_id, tour_id) values (5, 'Great tour', '2023-01-03 01:04:14', 5, 10);
insert into review (id, content, created_at, client_id, tour_id) values (6, 'Great tour', '2023-02-01 14:59:39', 6, 12);
insert into review (id, content, created_at, client_id, tour_id) values (7, 'Very good cost', '2023-04-21 03:42:54', 7, 14);
insert into review (id, content, created_at, client_id, tour_id) values (8, 'I dont recommend it', '2023-01-25 13:16:17', 8, 16);
insert into review (id, content, created_at, client_id, tour_id) values (9, 'Very bad', '2023-04-08 02:14:25', 9, 18);
insert into review (id, content, created_at, client_id, tour_id) values (10, 'Very bad', '2022-11-30 10:51:23', 10, 20);
insert into review (id, content, created_at, client_id, tour_id) values (11, 'Very good cost', '2023-03-09 03:05:21', 11, 22);
insert into review (id, content, created_at, client_id, tour_id) values (12, 'Cool!', '2023-01-30 20:36:22', 12, 24);
insert into review (id, content, created_at, client_id, tour_id) values (13, 'Great tour', '2023-09-04 18:10:07', 13, 26);
insert into review (id, content, created_at, client_id, tour_id) values (14, 'Cool!', '2023-06-01 04:42:02', 14, 27);
insert into review (id, content, created_at, client_id, tour_id) values (15, 'I dont recommend it', '2023-03-27 18:21:26', 15, 30);