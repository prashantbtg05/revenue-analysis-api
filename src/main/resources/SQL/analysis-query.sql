WITH tempv AS
(

select a.member_id, sum(a.wager_amount) as WA ,sum(a.number_of_wagers) as NOW,
sum(a.win_amount) as WIA , a.activity_year_month as AYM, c.CALENDAR_YEAR_MONTH as CYM,
row_number() OVER (PARTITION BY a.member_id ORDER BY a.member_id) as Ranke
,LAG(c.CALENDAR_YEAR_MONTH,1) OVER (PARTITION BY a.member_id ORDER BY a.member_id) as prev_month

from Revenue_analysis a
FULL JOIN Calendar c
 
ON a.ACTIVITY_YEAR_MONTH = c.CALENDAR_YEAR_MONTH
AND EXTRACT(DAY FROM a.activity_date ) = c.CALENDAR_DAY_OF_MONTH

GROUP BY c.CALENDAR_YEAR_MONTH, a.activity_year_month,a.member_id

ORDER BY c.CALENDAR_YEAR_MONTH

) 
select tempv.member_id, tempv.AYM,tempv.CYM, tempv.WA , tempv.now, (tempv.cym - tempv.prev_month ) as diff, 
CASE
WHEN tempv.ranke =1 and tempv.member_id is not NULL THEN 'new'
WHEN tempv.cym-tempv.prev_month = 1 and tempv.member_id is not NULL THEN 'retained'
WHEN tempv.cym-tempv.prev_month > 1 and tempv.member_id is not NULL THEN 'reactivated'
WHEN tempv.member_id is not NULL THEN 'lapsed'
END status

FROM tempv
ORDER BY tempv.CYM