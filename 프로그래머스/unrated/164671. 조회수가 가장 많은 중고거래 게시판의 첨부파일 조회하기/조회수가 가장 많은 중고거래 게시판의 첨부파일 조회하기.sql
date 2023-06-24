-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', BOARD_ID, '/',FILE_ID, FILE_NAME, FILE_EXT ) FILE_PATH
FROM USED_GOODS_FILE
WHERE BOARD_ID = (
    select BOARD_ID
    FROM USED_GOODS_BOARD
    WHERE VIEWS = (select max(VIEWS) FROM USED_GOODS_BOARD)
                )
                order by FILE_ID DESC