-- 1 Provide a query that shows the number of trades per client
-- traded on the 1st of August, 2012.

select CustomerId, count(TradeId)
from Trades
where TradeDate = "01/08/2012"
group by CustomerId


-- 2 Provide a query that shows the trade details of the largest
-- (in terms of quantity) trade done for each client.
-- The result set should show the customer name, instrument name,
-- quantity, price, and trade date.
select tr0.CustomerId, cus.CustomerName, ins.InstrumentName, tr0.TradeDate, tr0.Quantity, tr0.Price
from Trades tr0, Customers cus, Instruments ins
where tr0.CustomerId = cus.CustomerId
and tr0.InstrumentId = ins.InstrumentId
group by tr0.CustomerId, tr0.InstrumentId, tr0.TradeDate, tr0.Quantity, tr0.Price
having tr0.Quantity=
(select max(tr1.Quantity)
from Trades tr1
where tr1.CustomerId = tr0.CustomerId
group by tr1.CustomerId)


-- 3 Produce a query that shows the last date a client traded.
-- The result set should show the customer id, customer name,
-- and last trade date (or null if the client has never traded).
select cus.*, ltr.*
from Customers cus
left join
(select tr1.CustomerId, max(tr1.TradeDate) lastTradeDate
from Trades tr1
group by tr1.CustomerId) ltr
on cus.CustomerId = ltr.CustomerId




