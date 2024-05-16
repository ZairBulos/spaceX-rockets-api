-- Falcon 1
INSERT INTO rockets (id, name, description, active, stages, boosters, cost_per_launch, success_rate_pct, first_flight, country)
VALUES (1, 'Falcon 1', 'The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009. On 28 September 2008, Falcon 1 became the first privately-developed liquid-fuel launch vehicle to go into orbit around the Earth.', false, 2, 0, 6700000, 40, '2006-03-24', 'Republic of the Marshall Islands');

INSERT INTO rocket_height (id, meters, feet, rocket_id)
VALUES (1, 22.25, 73, 1);

INSERT INTO rocket_diameter (id, meters, feet, rocket_id)
VALUES (1, 1.68, 5.5, 1);

INSERT INTO rocket_mass (id, kg, lb, rocket_id)
VALUES (1, 30146, 66460, 1);

-- Falcon 9
INSERT INTO rockets (id, name, description, active, stages, boosters, cost_per_launch, success_rate_pct, first_flight, country)
VALUES (2, 'Falcon 9', 'Falcon 9 is a two-stage rocket designed and manufactured by SpaceX for the reliable and safe transport of satellites and the Dragon spacecraft into orbit.', true, 2, 0, 50000000, 97, '2010-06-04', 'United States');

INSERT INTO rocket_height (id, meters, feet, rocket_id)
VALUES (2, 70, 229.6, 2);

INSERT INTO rocket_diameter (id, meters, feet, rocket_id)
VALUES (2, 3.7, 12, 2);

INSERT INTO rocket_mass (id, kg, lb, rocket_id)
VALUES (2, 549054, 1207920, 2);

-- Falcon Heavy
INSERT INTO rockets (id, name, description, active, stages, boosters, cost_per_launch, success_rate_pct, first_flight, country)
VALUES (3, 'Falcon Heavy', 'With the ability to lift into orbit over 54 metric tons (119,000 lb)--a mass equivalent to a 737 jetliner loaded with passengers, crew, luggage and fuel--Falcon Heavy can lift more than twice the payload of the next closest operational vehicle, the Delta IV Heavy, at one-third the cost.', true, 2, 2, 90000000, 100, '2018-02-06', 'United States');

INSERT INTO rocket_height (id, meters, feet, rocket_id)
VALUES (3, 70, 229.6, 3);

INSERT INTO rocket_diameter (id, meters, feet, rocket_id)
VALUES (3, 12.2, 39.9, 3);

INSERT INTO rocket_mass (id, kg, lb, rocket_id)
VALUES (3, 1420788, 3125735, 3);

-- Big Falcon Rocket
INSERT INTO rockets (id, name, description, active, stages, boosters, cost_per_launch, success_rate_pct, first_flight, country)
VALUES (4, 'Big Falcon Rocket', 'BFR is a privately funded next-generation reusable launch vehicle and spacecraft system developed by SpaceX. It was announced by Elon Musk in September 2017; the first spacecraft prototype was being manufactured as of March 2018 and will begin testing in early 2019. The overall space vehicle architecture includes both launch vehicles and spacecraft that are intended to completely replace all of SpaceX`s existing space hardware by the early 2020s as well as ground infrastructure for rapid launch and relaunch, and zero-gravity propellant transfer technology to be deployed in low Earth orbit (LEO). The large payload to Earth orbit of up to 150,000 kg (330,000 lb) makes BFR a super heavy-lift launch vehicle.', false, 2, 0, 7000000, 0, '2019-12-01', 'United States');

INSERT INTO rocket_height (id, meters, feet, rocket_id)
VALUES (4, 106, 348, 4);

INSERT INTO rocket_diameter (id, meters, feet, rocket_id)
VALUES (4, 9, 30, 4);

INSERT INTO rocket_mass (id, kg, lb, rocket_id)
VALUES (4, 4400000, 9700000, 4);
