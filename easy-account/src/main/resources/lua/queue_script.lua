local num = redis.call('LLEN', KEYS[1])
if num >= tonumber(ARGV[1]) then
    redis.call('RPOP', KEYS[1])
    num = num - 1
end
redis.call('LPUSH', KEYS[1], ARGV[2])
return num + 1