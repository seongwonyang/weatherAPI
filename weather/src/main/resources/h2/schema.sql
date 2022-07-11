DROP TABLE IF EXISTS weather;
DROP SEQUENCE IF EXISTS weather_seq;
CREATE TABLE weather(    
    id INT PRIMARY KEY,     
    date VARCHAR2(100),      
    location VARCHAR2(100),      
    degree FLOAT,
    precipitation FLOAT(30),
    humidity FLOAT(30),
    wind FLOAT(30)
);
create sequence weather_seq;  